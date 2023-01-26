package com.jfalstaff.singitout.presentation.navigation

import com.github.terrakok.cicerone.Screen
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums

interface IScreens {
    fun mainFragmentScreen(): Screen
    fun albumTracksScreen(album: Albums): Screen
    fun artistInfoScreen(id: Int): Screen
    fun songLyricsScreen(id: Int): Screen
}