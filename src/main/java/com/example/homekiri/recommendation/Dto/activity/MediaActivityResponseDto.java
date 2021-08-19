package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.MediaActivity;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Getter
public class MediaActivityResponseDto {
    private Long idx;
    private Long genreIdx;
    private String mediaName;
    private Long screeningYear;
    private String country;
    private List<String> actorList;

    public MediaActivityResponseDto(MediaActivity entity){
        this.idx = entity.getIdx();
        this.genreIdx = entity.getGenreIdx();
        this.mediaName = entity.getMediaName();
        this.screeningYear = entity.getScreeningYear();
        this.country = entity.getCountry();
        this.actorList = Parsing(entity.getActorList());
    }

    public List<String> Parsing(String Input){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(Input, ", ");
        while(st1.hasMoreTokens()) {
            res.add(st1.nextToken());
        }
        return res;
    }
}
