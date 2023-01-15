package com.jfalstaff.singitout.data.mapper

import com.jfalstaff.singitout.data.network.dto.searchDto.*
import com.jfalstaff.singitout.domain.entities.searchEntity.*
import javax.inject.Inject

class SearchResultMapper @Inject constructor(){

    fun mapResponseServerDtoToEntity(responseServerDto: ResponseServerDto): ResponseServer {
        return ResponseServer(
            meta = mapMetaDtoToEntity(responseServerDto.meta),
            response = mapResponseDtoToEntity(responseServerDto.response)
        )
    }

    private fun mapResponseDtoToEntity(responseDto: ResponseDto): Response {
        return Response(
            hits = convertListHitsDtoToEntity(responseDto.hits)
        )
    }

    private fun convertListHitsDtoToEntity(hitsDto: List<HitDto>?): List<Hit>? {
        return hitsDto?.map {
            mapHitDtoToEntity(it)
        }
    }

    private fun mapMetaDtoToEntity(metaDto: MetaDto): Meta {
        return Meta(
            status = metaDto.status
        )
    }


    private fun mapHitDtoToEntity(hitDto: HitDto): Hit {
        return Hit(
            type = hitDto.type,
            result = mapResultDtoToEntity(hitDto.result)
        )
    }

    private fun mapResultDtoToEntity(resultDto: ResultDto): Result {
        return Result(
            apiPath = resultDto.apiPath,
            artistNames = resultDto.artistNames,
            fullTitle = resultDto.fullTitle,
            headerImageThumbnailUrl = resultDto.headerImageThumbnailUrl,
            headerImageUrl = resultDto.headerImageUrl,
            id = resultDto.id,
            language = resultDto.language,
            releaseDateComponents = mapReleaseDateComponentsDtoToEntity(resultDto.releaseDateComponents),
            releaseDateForDisplay = resultDto.releaseDateForDisplay,
            //  releaseDateWithAbbreviatedMonthForDisplay = resultDto.releaseDateWithAbbreviatedMonthForDisplay,
            songArtImageThumbnailUrl = resultDto.songArtImageThumbnailUrl,
            songArtImageUrl = resultDto.songArtImageUrl,
            title = resultDto.title,
            titleWithFeatured = resultDto.titleWithFeatured,
            url = resultDto.url,
            primaryArtist = mapPrimaryArtistDtoToEntity(resultDto.primaryArtist)
        )
    }

    private fun mapPrimaryArtistDtoToEntity(artistDto: PrimaryArtistDto): PrimaryArtist {
        return PrimaryArtist(
            apiPath = artistDto.apiPath,
            headerImageUrl = artistDto.headerImageUrl,
            id = artistDto.id,
            imageUrl = artistDto.imageUrl,
            name = artistDto.name,
            url = artistDto.url
        )
    }

    private fun mapReleaseDateComponentsDtoToEntity(dateComponentsDto: ReleaseDateComponentsDto?): ReleaseDateComponents {
        return ReleaseDateComponents(
            year = dateComponentsDto?.year ?: 0,
            month = dateComponentsDto?.month ?: 0,
            day = dateComponentsDto?.day ?: 0
        )
    }
}