package com.example.homekiri.recommendation.Dto.preference;

import com.example.homekiri.model.preferences.MediaPreference;
import lombok.Getter;

@Getter
public class MediaPreferenceDto {
    private Long idx;
    private Long userIdx;
    private Long horror;
    private Long romance;
    private Long comedy;
    private Long crime;
    private Long fantasy;
    private Long drama;
    private Long action;
    private Long scienceFiction;
    private Long animation;
    private Long tvShow;
    private Long classic;
    private Long netflix;
    private Long wave;
    private Long watcha;
    private Long tving;
    private Long tvn;
    private Long jtbc;
    private Long mbc;
    private Long sbs;
    private Long kbs;

    public MediaPreferenceDto(MediaPreference entity){
        this.idx = entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.horror = entity.getHorror();
        this.romance = entity.getRomance();
        this.comedy = entity.getComedy();
        this.crime = entity.getCrime();
        this.fantasy = entity.getFantasy();
        this.drama = entity.getDrama();
        this.action = entity.getAction();
        this.scienceFiction = entity.getScienceFiction();
        this.animation = entity.getAnimation();
        this.tvShow = entity.getTvShow();
        this.classic = entity.getClassic();
        this.netflix = entity.getNetflix();
        this.wave = entity.getWave();
        this.watcha = entity.getWatcha();
        this.tving = entity.getTving();
        this.tvn = entity.getTvn();
        this.jtbc = entity.getJtbc();
        this.mbc = entity.getMbc();
        this.sbs = entity.getSbs();
        this.kbs = entity.getKbs();
    }
}
