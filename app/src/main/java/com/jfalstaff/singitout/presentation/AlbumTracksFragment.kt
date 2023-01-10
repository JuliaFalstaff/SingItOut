package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.data.network.dto.albums.Albums
import com.jfalstaff.singitout.databinding.FragmentAlbumTracksBinding
import com.jfalstaff.singitout.presentation.adapters.AlbumTracksAdapter

class AlbumTracksFragment : Fragment() {

    private var _binding: FragmentAlbumTracksBinding? = null
    private val binding get() = _binding!!
    private var adapter: AlbumTracksAdapter? = null
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[AlbumTrackViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumTracksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val album = arguments?.getParcelable(ALBUM_KEY) ?: Albums()
        initAdapter()
        initViewModel(album)
        renderAlbumInfo(album)
    }

    private fun renderAlbumInfo(album: Albums) {
        binding.albumTitleTextView.text = album.fullTitle
        binding.releaseAlbumDateTextView.text = album.releaseDateComponents.toString()
        Glide.with(requireActivity())
            .load(album.coverArtUrl)
            .placeholder(R.drawable.progress_animation)
            .into(binding.albumCoverImageView)
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
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SongLyricsFragment.newInstance(it.song?.id ?: 0))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val ALBUM_KEY = "album"
        fun newInstance(album: Albums)= AlbumTracksFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ALBUM_KEY, album)
            }
        }
    }
}