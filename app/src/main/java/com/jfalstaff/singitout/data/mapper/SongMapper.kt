package com.jfalstaff.singitout.data.mapper

import com.jfalstaff.singitout.data.network.dto.searchDto.MetaDto
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtistDto
import com.jfalstaff.singitout.data.network.dto.song.AlbumDto
import com.jfalstaff.singitout.data.network.dto.song.ResponseDto
import com.jfalstaff.singitout.data.network.dto.song.ResponseSongDto
import com.jfalstaff.singitout.data.network.dto.song.SongDto
import com.jfalstaff.singitout.domain.entities.searchEntity.Meta
import com.jfalstaff.singitout.domain.entities.searchEntity.PrimaryArtist
import com.jfalstaff.singitout.domain.entities.songEntity.Album
import com.jfalstaff.singitout.domain.entities.songEntity.Response
import com.jfalstaff.singitout.domain.entities.songEntity.ResponseSong
import com.jfalstaff.singitout.domain.entities.songEntity.Song
import javax.inject.Inject

class SongMapper @Inject constructor() {
    fun mapResponseSongDtoToEntity(responseSongDto: ResponseSongDto): ResponseSong {
        return ResponseSong(
            meta = mapMetaDtoToEntity(responseSongDto.meta),
            response = mapResponseDtoToEntity(responseSongDto.response)
        )
    }

    private fun mapResponseDtoToEntity(responseDto: ResponseDto): Response {
        return Response(
            song = mapSongDtoToEntity(responseDto.song)
        )
    }

    private fun mapSongDtoToEntity(songDto: SongDto): Song {
        return Song(
            appleMusicId = songDto.appleMusicId,
            appleMusicPlayerUrl = songDto.appleMusicPlayerUrl,
            artistNames = songDto.artistNames,
            fullTitle = songDto.fullTitle,
            headerImageThumbnailUrl = songDto.headerImageThumbnailUrl,
            headerImageUrl = songDto.headerImageUrl,
            id = songDto.id,
            path = songDto.path,
            releaseDate = songDto.releaseDate,
            releaseDateForDisplay = songDto.releaseDateForDisplay,
            releaseDateWithAbbreviatedMonthForDisplay = songDto.releaseDateWithAbbreviatedMonthForDisplay,
            songArtImageThumbnailUrl = songDto.songArtImageThumbnailUrl,
            songArtImageUrl = songDto.songArtImageUrl,
            title = songDto.title,
            titleWithFeatured = songDto.titleWithFeatured,
            url = songDto.url,
            album = mapSongAlbumDtoToEntity(songDto.album),
            primaryArtist = mapPrimaryArtistDtoToEntity(songDto.primaryArtist),
        )
    }

    private fun mapPrimaryArtistDtoToEntity(artistDto: PrimaryArtistDto?): PrimaryArtist? {
        return PrimaryArtist(
            apiPath = artistDto?.apiPath,
            headerImageUrl = artistDto?.headerImageUrl,
            id = artistDto?.id ?: 0,
            imageUrl = artistDto?.imageUrl,
            name = artistDto?.name,
            url = artistDto?.url
        )
    }

    private fun mapSongAlbumDtoToEntity(albumDto: AlbumDto?): Album {
        return Album(
            apiPath = albumDto?.apiPath,
            coverArtUrl = albumDto?.coverArtUrl,
            fullTitle = albumDto?.fullTitle,
            id = albumDto?.id ?: 0,
            name = albumDto?.name,
            url = albumDto?.url,
        )
    }

    private fun mapMetaDtoToEntity(metaDto: MetaDto): Meta {
        return Meta(
            status = metaDto.status
        )
    }
}