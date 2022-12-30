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
import com.jfalstaff.singitout.data.network.dto.artists.Artist
import com.jfalstaff.singitout.databinding.FragmentArtistInfoBinding
import com.jfalstaff.singitout.presentation.adapters.AlbumsAdapter

class ArtistInfoFragment: Fragment() {

    private var _binding: FragmentArtistInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy {
        ViewModelProvider(this)[ArtistInfoViewModel::class.java]
    }
    private var adapter: AlbumsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtistInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

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
    }

    private fun renderArtistInfo(artist: Artist?) = with(binding) {
        artistName.text = artist?.name
        artistDescription.text = artist?.description?.plain
        facebookNameTextView.text = artist?.facebookName
        instagramNameTextView.text = artist?.instagramName
        twitterNameTextView.text = artist?.twitterName
        Glide.with(requireActivity())
            .load(artist?.imageUrl)
            .circleCrop()
            .placeholder(R.drawable.progress_animation)
            .into(artistPosterImageView)

        Glide.with(requireActivity())
            .load(artist?.headerImageUrl)
            .into(artistBackgroundPosterImageView)

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
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