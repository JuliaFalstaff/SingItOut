package com.jfalstaff.singitout.di

import com.jfalstaff.singitout.presentation.*
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class, CiceroneModule::class])
interface ApplicationComponent {

    fun inject(artistInfoFragment: ArtistInfoFragment)
    fun inject(albumTracksFragment: AlbumTracksFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(songLyricsFragment: SongLyricsFragment)
    fun inject(mainActivity: MainActivity)
}