package com.jfalstaff.singitout.presentation.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.presentation.AlbumTracksFragment
import com.jfalstaff.singitout.presentation.ArtistInfoFragment
import com.jfalstaff.singitout.presentation.MainFragment
import com.jfalstaff.singitout.presentation.SongLyricsFragment
import javax.inject.Inject

class AppScreen @Inject constructor() : IScreens {
    override fun mainFragmentScreen(): Screen {
        return FragmentScreen { MainFragment.newInstance() }
    }

    override fun albumTracksScreen(album: Albums): Screen {
        return FragmentScreen { AlbumTracksFragment.newInstance(album = album) }
    }

    override fun artistInfoScreen(id: Int): Screen {
        return FragmentScreen { ArtistInfoFragment.newInstance(id = id) }
    }

    override fun songLyricsScreen(id: Int): Screen {
        return FragmentScreen { SongLyricsFragment.newInstance(id = id) }
    }
}