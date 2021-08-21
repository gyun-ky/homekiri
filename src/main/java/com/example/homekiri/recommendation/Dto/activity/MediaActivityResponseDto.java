package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.model.activity.Info.MediaImg;
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
    private String description;
    private String imgUrl;
    //private List<String>


    public MediaActivityResponseDto(MediaActivity entity1, MediaImg entity2){
        this.idx = entity1.getIdx();
        this.genreIdx = entity1.getGenreIdx();
        this.mediaName = entity1.getMediaName();
        this.screeningYear = entity1.getScreeningYear();
        this.country = entity1.getCountry();
        this.actorList = Parsing(entity1.getActorList());
        this.description = entity2.getDescription();
        this.imgUrl = entity2.getImgUrl();
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
