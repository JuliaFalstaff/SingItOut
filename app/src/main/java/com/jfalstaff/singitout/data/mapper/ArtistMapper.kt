package com.jfalstaff.singitout.data.mapper

import com.jfalstaff.singitout.data.network.dto.artists.ArtistDto
import com.jfalstaff.singitout.data.network.dto.artists.DescriptionDto
import com.jfalstaff.singitout.data.network.dto.artists.ResponseArtistDto
import com.jfalstaff.singitout.data.network.dto.artists.ResponseDto
import com.jfalstaff.singitout.domain.entities.artistEntity.Artist
import com.jfalstaff.singitout.domain.entities.artistEntity.Description
import com.jfalstaff.singitout.domain.entities.artistEntity.Response
import com.jfalstaff.singitout.domain.entities.artistEntity.ResponseArtist
import javax.inject.Inject

class ArtistMapper @Inject constructor() {

    fun mapResponseArtistDtoToEntity(responseArtistDto: ResponseArtistDto): ResponseArtist {
        return ResponseArtist(
            meta = responseArtistDto.meta,
            response = mapResponseDtoToEntity(responseArtistDto.response)
        )
    }

    private fun mapResponseDtoToEntity(responseDto: ResponseDto): Response {
        return Response(
            artist = mapArtistDtoToEntity(responseDto.artist)
        )
    }

    private fun mapArtistDtoToEntity(artistDto: ArtistDto): Artist {
        return Artist(
            apiPath = artistDto.apiPath,
            description = mapDescriptionDtoToEntity(artistDto.description),
            facebookName = artistDto.facebookName ?: "no data",
            followersCount = artistDto.followersCount,
            headerImageUrl = artistDto.headerImageUrl,
            id = artistDto.id,
            imageUrl = artistDto.imageUrl,
            instagramName = artistDto.instagramName ?: "no data",
            name = artistDto.name,
            twitterName = artistDto.twitterName ?: "no data",
            url = artistDto.url
        )
    }

    private fun mapDescriptionDtoToEntity(descriptionDto: DescriptionDto): Description {
        return Description(
            plain = descriptionDto.plain
        )
    }
}