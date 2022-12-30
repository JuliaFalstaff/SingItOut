package com.jfalstaff.singitout.domain

import com.jfalstaff.singitout.data.network.dto.albums.Albums
import kotlinx.coroutines.flow.Flow

interface IRepositoryMusic {
    suspend fun getArtistAlbums(id: Int): Flow<List<Albums>?>
}