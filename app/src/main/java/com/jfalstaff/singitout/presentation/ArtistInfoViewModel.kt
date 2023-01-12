package com.jfalstaff.singitout.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.data.network.api.ApiFactory
import com.jfalstaff.singitout.data.network.dto.albums.Albums
import com.jfalstaff.singitout.data.network.dto.artists.Artist
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.data.repository.RepositoryMusicImpl
import com.jfalstaff.singitout.domain.GetAlbumsUseCase
import com.jfalstaff.singitout.domain.GetArtistInfoUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ArtistInfoViewModel : ViewModel() {

    private val getArtistInfoUseCase = GetArtistInfoUseCase(RepositoryImpl(ApiFactory.apiService))
    private val getAlbumsUseCase = GetAlbumsUseCase(RepositoryMusicImpl(ApiFactory.apiMusicService))

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