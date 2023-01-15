package com.jfalstaff.singitout.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.domain.entities.tracksEntity.Track
import com.jfalstaff.singitout.domain.usecases.GetAlbumTracksUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlbumTrackViewModel @Inject constructor(
    private val getAlbumTracksUseCase: GetAlbumTracksUseCase
) : ViewModel() {

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