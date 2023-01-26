package com.jfalstaff.singitout.domain.repository

import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import kotlinx.coroutines.flow.Flow

interface IRepositoryMusic {
    suspend fun getArtistAlbums(id: Int): Flow<List<Albums>?>
}