package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.databinding.FragmentArtistInfoBinding
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.domain.entities.artistEntity.Artist
import com.jfalstaff.singitout.presentation.adapters.AlbumsAdapter
import com.jfalstaff.singitout.presentation.core.BaseFragment
import com.jfalstaff.singitout.presentation.glide.GlideFactory
import com.jfalstaff.singitout.presentation.viewmodels.ArtistInfoViewModel

class ArtistInfoFragment :
    BaseFragment<FragmentArtistInfoBinding>(FragmentArtistInfoBinding::inflate) {

    private val viewModel by lazy {
        ViewModelProvider(this)[ArtistInfoViewModel::class.java]
    }
    private var adapter: AlbumsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val artistId = arguments?.getInt(ID_ARTIST_KEY) ?: 0
        initViewModels(artistId)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = AlbumsAdapter()
        binding.albumsRecyclerView.adapter = adapter
    }

    private fun initViewModels(artistId: Int) {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.loadArtistInfo(artistId)
        viewModel.artistInfo.observe(viewLifecycleOwner) {
            renderArtistInfo(it)
        }
        viewModel.loadArtistAlbums(artistId)
        viewModel.albums.observe(viewLifecycleOwner) {
            renderAlbumData(it)
        }
    }

    private fun renderAlbumData(list: List<Albums>?) {
        adapter?.submitList(list)
        binding.progressBar.visibility = View.INVISIBLE
        setAlbumListener()
    }

    private fun setAlbumListener() {
        adapter?.onAlbumItemClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, AlbumTracksFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
    }

    private fun renderArtistInfo(artist: Artist?) = with(binding) {
        artistName.text = artist?.name
        artistDescription.text = artist?.description?.plain
        facebookNameTextView.text = artist?.facebookName
        instagramNameTextView.text = artist?.instagramName
        twitterNameTextView.text = artist?.twitterName
        GlideFactory.loadCircleCrop(requireView(), artist?.imageUrl, artistPosterImageView)
        GlideFactory.load(requireView(), artist?.headerImageUrl, artistBackgroundPosterImageView)
    }

    companion object {
        private const val ID_ARTIST_KEY = "artist_id"
        fun newInstance(id: Int) = ArtistInfoFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_ARTIST_KEY, id)
            }
        }
    }
}