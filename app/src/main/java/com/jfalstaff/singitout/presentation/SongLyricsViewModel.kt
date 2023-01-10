package com.jfalstaff.singitout.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.data.network.ApiFactory
import com.jfalstaff.singitout.data.network.dto.lyrics.Lyrics
import com.jfalstaff.singitout.data.repository.RepositoryLyricsImpl
import com.jfalstaff.singitout.domain.GetSongLyricUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SongLyricsViewModel : ViewModel() {
    private val getSongLyricUseCase =
        GetSongLyricUseCase(RepositoryLyricsImpl(ApiFactory.apiRapidLyricsService))

    private var _lyrics = MutableLiveData<Lyrics>()
    val lyrics: LiveData<Lyrics> = _lyrics

    fun loadSongLyrics(id: Int) {
        viewModelScope.launch {
            getSongLyricUseCase(id)
                .catch { error ->
                    Log.d("VVV VM lyrics", error.stackTraceToString().toString())
                }
                .collect { lyrics ->
                    _lyrics.value = lyrics
                }
        }
    }
}