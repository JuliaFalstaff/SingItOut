package com.jfalstaff.singitout.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.data.network.ApiFactory
import com.jfalstaff.singitout.data.network.dto.tracks.Track
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.domain.GetAlbumTracksUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class AlbumTrackViewModel : ViewModel() {

    private val getAlbumTracksUseCase = GetAlbumTracksUseCase(RepositoryImpl(ApiFactory.apiService))
    private var _tracks = MutableLiveData<List<Track>>()
    val tracks: LiveData<List<Track>> = _tracks

    fun loadAlbumTracks(id: Int) {
        viewModelScope.launch {
            getAlbumTracksUseCase(id = id)
                .catch { error ->
                    Log.d("Tracks error", error.stackTraceToString())
                }
                .collect { tracks ->
                    _tracks.value = tracks
                }
        }
    }
}