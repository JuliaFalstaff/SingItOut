package com.jfalstaff.singitout.data.mapper

import com.jfalstaff.singitout.data.network.dto.searchDto.MetaDto
import com.jfalstaff.singitout.data.network.dto.tracks.ResponseAlbumTracksDto
import com.jfalstaff.singitout.data.network.dto.tracks.ResponseDto
import com.jfalstaff.singitout.data.network.dto.tracks.SongDto
import com.jfalstaff.singitout.data.network.dto.tracks.TrackDto
import com.jfalstaff.singitout.domain.entities.searchEntity.Meta
import com.jfalstaff.singitout.domain.entities.tracksEntity.Response
import com.jfalstaff.singitout.domain.entities.tracksEntity.ResponseAlbumTracks
import com.jfalstaff.singitout.domain.entities.tracksEntity.Song
import com.jfalstaff.singitout.domain.entities.tracksEntity.Track

class TrackMapper {
    fun mapResponseAlbumTracksDtoToEntity(responseAlbumTracksDto: ResponseAlbumTracksDto): ResponseAlbumTracks {
        return ResponseAlbumTracks(
            meta = mapMetaDtoToEntity(responseAlbumTracksDto.meta),
            response = mapResponseDtoToEntity(responseAlbumTracksDto.response)
        )
    }

    private fun mapResponseDtoToEntity(responseDto: ResponseDto): Response {
        return Response(
            tracks = mapTrackListDtoToEntity(responseDto.tracks)
        )
    }

    private fun mapTrackListDtoToEntity(tracksList: List<TrackDto>?): List<Track>? {
        return tracksList?.map {
            Track(
                number = it.number,
                song = mapSongDtoToEntity(it.song)
            )
        }
    }

    private fun mapSongDtoToEntity(songDto: SongDto?): Song {
        return Song(
            apiPath = songDto?.apiPath,
            artistNames = songDto?.artistNames,
            fullTitle = songDto?.fullTitle,
            headerImageThumbnailUrl = songDto?.headerImageThumbnailUrl,
            headerImageUrl = songDto?.headerImageUrl,
            id = songDto?.id,
            releaseDateForDisplay = songDto?.releaseDateForDisplay,
            songArtImageThumbnailUrl = songDto?.songArtImageThumbnailUrl,
            songArtImageUrl = songDto?.songArtImageUrl,
            title = songDto?.title,
            titleWithFeatured = songDto?.titleWithFeatured,
            url = songDto?.url,
            primaryArtist = songDto?.primaryArtist,
        )
    }

    private fun mapMetaDtoToEntity(metaDto: MetaDto): Meta {
        return Meta(
            status = metaDto.status
        )
    }
}