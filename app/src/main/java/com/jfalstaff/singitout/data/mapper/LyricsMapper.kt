package com.jfalstaff.singitout.data.mapper

import com.jfalstaff.singitout.data.network.dto.lyrics.BodyDto
import com.jfalstaff.singitout.data.network.dto.lyrics.LyricsDto
import com.jfalstaff.singitout.data.network.dto.lyrics.LyricsResponseDto
import com.jfalstaff.singitout.data.network.dto.lyrics.LyricsTextDto
import com.jfalstaff.singitout.domain.entities.lyricsEntity.Body
import com.jfalstaff.singitout.domain.entities.lyricsEntity.Lyrics
import com.jfalstaff.singitout.domain.entities.lyricsEntity.LyricsResponse
import com.jfalstaff.singitout.domain.entities.lyricsEntity.LyricsText
import javax.inject.Inject

class LyricsMapper @Inject constructor() {
    fun mapLyricsResponseDtoToEntity(lyricsResponseDto: LyricsResponseDto): LyricsResponse {
        return LyricsResponse(
            lyrics = mapLyricsDtoToEntity(lyricsResponseDto.lyrics)
        )
    }

    private fun mapLyricsDtoToEntity(lyricsDto: LyricsDto): Lyrics {
        return Lyrics(
            type = lyricsDto.type,
            apiPath = lyricsDto.apiPath,
            lyrics = mapLyricsTextDtoToEntity(lyricsDto.lyrics),
            path = lyricsDto.path,
            songId = lyricsDto.songId
        )
    }

    private fun mapLyricsTextDtoToEntity(lyricsTextDto: LyricsTextDto?): LyricsText {
        return LyricsText(
            body = mapBodyDtoToEntity(lyricsTextDto?.body)
        )
    }

    private fun mapBodyDtoToEntity(bodyDto: BodyDto?): Body {
        return Body(
            plain = bodyDto?.plain ?: ""
        )
    }
}