package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class WorkoutActivityResponseDto {
    private Long idx;
    private Long typeIdx;
    private Long difficultyIdx;
    private Long targetIdx;
    private String exerciseName;
    private String description;

    public WorkoutActivityResponseDto(WorkoutActivity entity){
        this.idx = entity.getIdx();
        this.typeIdx = entity.getTypeIdx();
        this.difficultyIdx = entity.getDifficultyIdx();
        this.targetIdx = entity.getTargetIdx();
        this.exerciseName = entity.getExerciseName();
        this.description = entity.getDescription();
    }
}
