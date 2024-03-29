package com.jfalstaff.singitout.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.jfalstaff.singitout.databinding.FragmentAlbumTracksBinding
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.presentation.adapters.AlbumTracksAdapter
import com.jfalstaff.singitout.presentation.core.BaseFragment
import com.jfalstaff.singitout.presentation.glide.GlideFactory
import com.jfalstaff.singitout.presentation.navigation.IScreens
import com.jfalstaff.singitout.presentation.viewmodels.AlbumTrackViewModel
import com.jfalstaff.singitout.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

class AlbumTracksFragment :
    BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate) {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screen: IScreens

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var adapter: AlbumTracksAdapter? = null
    private val viewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[AlbumTrackViewModel::class.java]
    }
    private val component by lazy {
        (requireActivity().application as SingItOutApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val album = arguments?.getParcelable(ALBUM_KEY) ?: Albums()
        initAdapter()
        initViewModel(album)
        renderAlbumInfo(album)
    }

    private fun renderAlbumInfo(album: Albums) {
        binding.progressBarTracks.visibility = View.VISIBLE
        binding.albumTitleTextView.text = album.fullTitle
        binding.releaseAlbumDateTextView.text = album.releaseDateComponents?.year.toString()
        GlideFactory.load(requireView(), album.coverArtUrl, binding.albumCoverImageView)
        binding.progressBarTracks.visibility = View.INVISIBLE
        GlideFactory.loadPaletteColorBackground(
            requireView(),
            album.coverArtUrl,
            binding.albumBackgroundImageView
        )
    }

    private fun initViewModel(album: Albums) {
        viewModel.loadAlbumTracks(album.id)
        viewModel.tracks.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }
    }

    private fun initAdapter() {
        adapter = AlbumTracksAdapter()
        binding.recyclerViewAlbumTracks.adapter = adapter
        adapter?.onTrackItemClickListener = {
            router.navigateTo(screen.songLyricsScreen(it.song?.id ?: 0))
        }
    }

    companion object {
        private const val ALBUM_KEY = "album"
        fun newInstance(album: Albums) = AlbumTracksFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ALBUM_KEY, album)
            }
        }
    }
}