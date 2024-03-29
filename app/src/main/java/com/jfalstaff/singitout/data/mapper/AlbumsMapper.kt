package com.jfalstaff.singitout.data.mapper

import com.jfalstaff.singitout.data.network.dto.albums.*
import com.jfalstaff.singitout.data.network.dto.searchDto.MetaDto
import com.jfalstaff.singitout.domain.entities.albumsEntity.*
import com.jfalstaff.singitout.domain.entities.searchEntity.Meta
import javax.inject.Inject

class AlbumsMapper @Inject constructor() {
    fun mapResponseAlbumDtoToEntity(responseAlbumsDto: ResponseAlbumsDto): ResponseAlbums {
        return ResponseAlbums(
            meta = mapMetaDtoToEntity(responseAlbumsDto.meta),
            response = mapResponseDtoToEntity(responseAlbumsDto.response)
        )
    }

    private fun mapResponseDtoToEntity(responseDto: ResponseDto?): Response {
        return Response(
            albums = mapAlbumsListDtoToListEntity(responseDto?.albums),
            nextPage = responseDto?.nextPage ?: EMPTY_NEXT_PAGE
        )
    }

    private fun mapAlbumsListDtoToListEntity(albumsList: List<AlbumsDto>?): List<Albums>? {
        return albumsList?.map {
            mapAlbumDtoToEntity(it)
        }
    }

    private fun mapMetaDtoToEntity(metaDto: MetaDto): Meta {
        return Meta(
            status = metaDto.status
        )
    }

    private fun mapAlbumDtoToEntity(albumsDto: AlbumsDto): Albums {
        return Albums(
            apiPath = albumsDto.apiPath,
            coverArtThumbnailUrl = albumsDto.coverArtThumbnailUrl,
            coverArtUrl = albumsDto.coverArtUrl,
            fullTitle = albumsDto.fullTitle,
            id = albumsDto.id,
            name = albumsDto.name,
            releaseDateComponents = mapReleaseDateDtoToEntity(albumsDto.releaseDateComponents),
            url = albumsDto.url,
            artist = mapArtistAlbumDtoToEntity(albumsDto.artist)
        )
    }

    private fun mapArtistAlbumDtoToEntity(albumDto: ArtistAlbumDto?): ArtistAlbum {
        return ArtistAlbum(
            headerImageUrl = albumDto?.headerImageUrl,
            id = albumDto?.id ?: EMPTY_INT_DATA,
            imageUrl = albumDto?.imageUrl,
            name = albumDto?.name,
            url = albumDto?.url,
        )
    }

    private fun mapReleaseDateDtoToEntity(dateDto: ReleaseDateComponentsDto?): ReleaseDateComponents? {
        return ReleaseDateComponents(
            year = dateDto?.year,
            month = dateDto?.month,
            day = dateDto?.day
        )
    }

    companion object {
        private const val EMPTY_INT_DATA = 0
        private const val EMPTY_NEXT_PAGE = ""
    }
}