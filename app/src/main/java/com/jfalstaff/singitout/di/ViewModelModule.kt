package com.jfalstaff.singitout.di

import androidx.lifecycle.ViewModel
import com.jfalstaff.singitout.presentation.viewmodels.AlbumTrackViewModel
import com.jfalstaff.singitout.presentation.viewmodels.ArtistInfoViewModel
import com.jfalstaff.singitout.presentation.viewmodels.MainViewModel
import com.jfalstaff.singitout.presentation.viewmodels.SongLyricsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AlbumTrackViewModel::class)
    fun bindAlbumTrackViewModule(viewModel: AlbumTrackViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArtistInfoViewModel::class)
    fun bindArtistInfoViewModel(viewModel: ArtistInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SongLyricsViewModel::class)
    fun bindSongViewModel(viewModel: SongLyricsViewModel): ViewModel
}