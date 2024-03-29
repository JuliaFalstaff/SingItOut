package com.jfalstaff.singitout.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import com.jfalstaff.singitout.databinding.FragmentArtistInfoBinding
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.domain.entities.artistEntity.Artist
import com.jfalstaff.singitout.presentation.adapters.AlbumsAdapter
import com.jfalstaff.singitout.presentation.core.BaseFragment
import com.jfalstaff.singitout.presentation.glide.GlideFactory
import com.jfalstaff.singitout.presentation.navigation.IScreens
import com.jfalstaff.singitout.presentation.viewmodels.ArtistInfoViewModel
import com.jfalstaff.singitout.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

class ArtistInfoFragment :
    BaseFragment<FragmentArtistInfoBinding>(FragmentArtistInfoBinding::inflate) {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screen: IScreens

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ArtistInfoViewModel::class.java]
    }
    private var adapter: AlbumsAdapter? = null
    private val component by lazy {
        (requireActivity().application as SingItOutApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
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
        binding.progressBarArtistInfo.visibility = View.VISIBLE
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
        startShimmering()
        adapter?.submitList(list)
        setAlbumListener()
        stopShimmering()
        binding.progressBarArtistInfo.visibility = View.INVISIBLE
    }

    private fun setAlbumListener() {
        adapter?.onAlbumItemClickListener = {
            router.navigateTo(screen.albumTracksScreen(it))
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
        setSocialMediaIconsListeners(artist)
    }

    private fun setSocialMediaIconsListeners(artist: Artist?) = with(binding) {
        facebookNameTextView.setOnClickListener {
            val fbUrl = "$FACEBOOK_BASE_URL${artist?.facebookName}"
            Intent(Intent.ACTION_VIEW, Uri.parse(fbUrl)).apply {
                startActivity(this)
            }
        }
        twitterNameTextView.setOnClickListener {
            val twitterUrl = "$TWITTER_BASE_URL${artist?.twitterName}"
            Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl)).apply {
                startActivity(this)
            }
        }
        instagramNameTextView.setOnClickListener {
            val instagramUrl = "$INSTAGRAM_BASE_URL${artist?.instagramName}"
            Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl)).apply {
                startActivity(this)
            }
        }
    }

    private fun startShimmering() = with(binding) {
        albumsPlaceholder.shimmerAlbumFrameLayout.startShimmer()
        albumsPlaceholder.shimmerAlbumFrameLayout.visibility = View.VISIBLE
        albumsRecyclerView.visibility = View.GONE
    }

    private fun stopShimmering() = with(binding)  {
        albumsPlaceholder.shimmerAlbumFrameLayout.stopShimmer()
        albumsPlaceholder.shimmerAlbumFrameLayout.visibility = View.INVISIBLE
        albumsRecyclerView.visibility = View.VISIBLE
    }

    companion object {
        private const val ID_ARTIST_KEY = "artist_id"
        private const val FACEBOOK_BASE_URL = "https://www.facebook.com/"
        private const val TWITTER_BASE_URL = "https://twitter.com/"
        private const val INSTAGRAM_BASE_URL = "https://www.instagram.com/"
        fun newInstance(id: Int) = ArtistInfoFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_ARTIST_KEY, id)
            }
        }
    }
}