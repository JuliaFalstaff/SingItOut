package com.jfalstaff.singitout.di

import com.jfalstaff.singitout.presentation.AlbumTracksFragment
import com.jfalstaff.singitout.presentation.ArtistInfoFragment
import com.jfalstaff.singitout.presentation.MainFragment
import com.jfalstaff.singitout.presentation.SongLyricsFragment
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(artistInfoFragment: ArtistInfoFragment)
    fun inject(albumTracksFragment: AlbumTracksFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(songLyricsFragment: SongLyricsFragment)
}