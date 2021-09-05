package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.media.model.MediaPlatform;
import com.example.homekiri.media.model.MediaActivity;
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
    private List<String> platforms;
    private String description;
    private String imgUrl;


    public MediaActivityResponseDto(MediaActivity entity1, MediaPlatform entity3){
        this.idx = entity1.getIdx();
        this.genreIdx = GenreIdxToGenre( entity1.getGenreIdx());
        this.mediaName = entity1.getMediaName();
        this.screeningYear = entity1.getScreeningYear();
        this.country = entity1.getCountry();
        this.actorList = CommaParsing(entity1.getActorList());
        this.platforms = DelimParsing(entity3.getPlatformIdx());
        this.description = entity1.getDescription();
        this.imgUrl = entity1.getMediaImg().getImgUrl();
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
    public String PlatformIdxToPlatform(String platformIdx){
        if(platformIdx.equals("1")) return "쿠팡플레이";
        else if(platformIdx.equals("2")) return "넷플릭스";
        else if(platformIdx.equals("3")) return "왓챠";
        else if(platformIdx.equals("4")) return "티빙";
        else if(platformIdx.equals("5")) return "웨이브";
        else if(platformIdx.equals("6")) return "네이버 시리즈온";
        else if(platformIdx.equals("7")) return "Google Play 무비";
        else if(platformIdx.equals("8")) return "네이버 시리즈온";
        else if(platformIdx.equals("9")) return "네이버 시리즈온";
        else if(platformIdx.equals("10")) return "웨이브";
        else if(platformIdx.equals("11")) return "아마존 프라임 비디오";
        else if(platformIdx.equals("12")) return "티빙";
        else if(platformIdx.equals("13")) return "Play24";
        else if(platformIdx.equals("14")) return "Google Play 무비";
        else if(platformIdx.equals("15")) return "Google Play 무비";
        else if(platformIdx.equals("16")) return "웨이브";
        else if(platformIdx.equals("17")) return "네이버 시리즈온";
        else if(platformIdx.equals("18")) return "티빙";
        else if(platformIdx.equals("19")) return "티빙";
        else if(platformIdx.equals("20")) return "쿠팡플레이";
        else if(platformIdx.equals("21")) return "웨이브";
        else if(platformIdx.equals("22")) return "웨이브";
        else if(platformIdx.equals("23")) return "Google Play 무비";
        else if(platformIdx.equals("24")) return "네이브 시리즈온";
        else if(platformIdx.equals("25")) return "네이브 시리즈온";
        else if(platformIdx.equals("26")) return "씨네폭스";
        else if(platformIdx.equals("27")) return "쿠팡플레이";
        else if(platformIdx.equals("28")) return "티빙";
        else if(platformIdx.equals("29")) return "네이버 시리즈온";
        else  return "넷플릭스";
    }
    public List<String> CommaParsing(String Input){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(Input, ", ");
        while(st1.hasMoreTokens()) {
            res.add(st1.nextToken());
        }
        return res;
    }
    public List<String> DelimParsing(String Input){
        List<String> res = new ArrayList<String>();
        StringTokenizer st1 = new StringTokenizer(Input, "delim");
        while(st1.hasMoreTokens()) {
            res.add(PlatformIdxToPlatform(st1.nextToken()));
        }
        System.out.println(res);
        return res;
    }

}
