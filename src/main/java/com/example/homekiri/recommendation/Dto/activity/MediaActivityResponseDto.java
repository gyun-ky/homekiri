package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.MediaActivity;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class MediaActivityResponseDto {
    private Long idx;
    private Long genreIdx;
    private String mediaName;
    private Long screeningYear;
    private String country;
    private String actorList;

    public MediaActivityResponseDto(MediaActivity entity){
        this.idx = entity.getIdx();
        this.genreIdx = entity.getGenreIdx();
        this.mediaName = entity.getMediaName();
        this.screeningYear = entity.getScreeningYear();
        this.country = entity.getCountry();
        this.actorList = entity.getActorList();
    }
}
