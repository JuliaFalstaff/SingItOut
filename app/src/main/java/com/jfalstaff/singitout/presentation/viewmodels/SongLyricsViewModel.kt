package com.jfalstaff.singitout.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.domain.entities.lyricsEntity.Lyrics
import com.jfalstaff.singitout.domain.entities.songEntity.Song
import com.jfalstaff.singitout.domain.usecases.GetSongInfoUseCase
import com.jfalstaff.singitout.domain.usecases.GetSongLyricUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SongLyricsViewModel @Inject constructor(
    private val getSongLyricUseCase: GetSongLyricUseCase,
    private val getSongInfo: GetSongInfoUseCase
) : ViewModel() {

    private var _lyrics = MutableLiveData<Lyrics>()
    val lyrics: LiveData<Lyrics> = _lyrics
    private var _songInfo = MutableLiveData<Song>()
    val songInfo: LiveData<Song> = _songInfo

    fun loadSongLyrics(id: Int) {
        viewModelScope.launch {
            getSongLyricUseCase(id)
                .catch { error ->
                    Log.d("VVV VM lyrics", error.stackTraceToString())
                }
                .collect { lyrics ->
                    _lyrics.value = lyrics
                }
        }
    }

    fun loadSongInfo(id: Int) {
        viewModelScope.launch {
            getSongInfo(id)
                .catch { error ->
                    Log.d("VVV VM song info", error.stackTraceToString())
                }
                .collect { songInfo ->
                    _songInfo.value = songInfo
                }
        }
    }
}