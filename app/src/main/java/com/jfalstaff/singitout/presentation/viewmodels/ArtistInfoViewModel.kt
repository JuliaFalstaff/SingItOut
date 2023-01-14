package com.jfalstaff.singitout.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.data.mapper.AlbumsMapper
import com.jfalstaff.singitout.data.mapper.SearchResultMapper
import com.jfalstaff.singitout.data.mapper.SongMapper
import com.jfalstaff.singitout.data.mapper.TrackMapper
import com.jfalstaff.singitout.data.network.api.ApiFactory
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.data.repository.RepositoryMusicImpl
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.domain.entities.artistEntity.Artist
import com.jfalstaff.singitout.domain.usecases.GetAlbumsUseCase
import com.jfalstaff.singitout.domain.usecases.GetArtistInfoUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ArtistInfoViewModel : ViewModel() {

    private val getArtistInfoUseCase =
        GetArtistInfoUseCase(
            RepositoryImpl(
                ApiFactory.apiService,
                SearchResultMapper(),
                TrackMapper(),
                SongMapper()
            )
        )
    private val getAlbumsUseCase =
        GetAlbumsUseCase(RepositoryMusicImpl(ApiFactory.apiMusicService, AlbumsMapper()))

    private var _artistInfo = MutableLiveData<Artist>()
    val artistInfo: LiveData<Artist> = _artistInfo

    private var _albums = MutableLiveData<List<Albums>?>()
    val albums: LiveData<List<Albums>?> = _albums

    fun loadArtistInfo(id: Int) {
        viewModelScope.launch {
            getArtistInfoUseCase(id)
                .catch { error ->
                    Log.d("VVV VM artist", error.stackTraceToString().toString())
                }
                .collect { artist ->
                    _artistInfo.value = artist
                }
        }
    }

    fun loadArtistAlbums(artistId: Int) {
        viewModelScope.launch {
            getAlbumsUseCase(artistId)
                .catch { error ->
                    Log.d("VVV VM album", error.cause.toString())
                    Log.d("VVV VM album", error.stackTraceToString())
                }
                .collect {
                    _albums.value = it
                }
        }
    }
}