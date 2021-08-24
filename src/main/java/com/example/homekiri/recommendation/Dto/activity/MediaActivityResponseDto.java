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
    private String genreIdx;
    private String mediaName;
    private Long screeningYear;
    private String country;
    private List<String> actorList;
    private String description;
    private String imgUrl;


    public MediaActivityResponseDto(MediaActivity entity1, MediaImg entity2){
        this.idx = entity1.getIdx();
        this.genreIdx = GenreIdxToGenre( entity1.getGenreIdx());
        this.mediaName = entity1.getMediaName();
        this.screeningYear = entity1.getScreeningYear();
        this.country = entity1.getCountry();
        this.actorList = Parsing(entity1.getActorList());
        this.description = entity1.getDescription();
        this.imgUrl = entity2.getImgUrl();
    }

    public String GenreIdxToGenre(Long genreIdx){
        if(genreIdx == 1) return "SF";
        else if(genreIdx == 2) return "가족";
        else if(genreIdx == 3) return "공포(호러)";
        else if(genreIdx == 4) return "다큐멘터리";
        else if(genreIdx == 5) return "드라마";
        else if(genreIdx == 6) return "멜로/로맨스";
        else if(genreIdx == 7) return "뮤지컬";
        else if(genreIdx == 8) return "미스터리";
        else if(genreIdx == 9) return "범죄";
        else if(genreIdx == 10) return "사극";
        else if(genreIdx == 11) return "서부극(웨스턴)";
        else if(genreIdx == 12) return "스릴러";
        else if(genreIdx == 13) return "시사/교양";
        else if(genreIdx == 14) return "애니메이션";
        else if(genreIdx == 15) return "액션";
        else if(genreIdx == 16) return "어드벤처";
        else if(genreIdx == 17) return "예능";
        else if(genreIdx == 18) return "전쟁";
        else if(genreIdx == 19) return "코미디";
        else return "판타지";
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
