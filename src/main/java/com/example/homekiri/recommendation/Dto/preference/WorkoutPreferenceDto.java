package com.example.homekiri.recommendation.Dto.preference;

import com.example.homekiri.model.preferences.WorkoutPreference;
import lombok.Getter;

@Getter
public class WorkoutPreferenceDto {
    private Long idx;
    private Long userIdx;
    private Long health;
    private Long yoga;
    private Long difficulty;

    public WorkoutPreferenceDto(WorkoutPreference entity){
        this.idx = entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.health = entity.getHealth();
        this.yoga = entity.getYoga();
        this.difficulty = entity.getDifficulty();
    }
}
