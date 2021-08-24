package com.example.homekiri.recommendation.Dto.activity;

import com.example.homekiri.recommendation.model.activity.Info.WorkoutImg;
import com.example.homekiri.recommendation.model.activity.Info.WorkoutVideo;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import lombok.Getter;

@Getter
public class WorkoutActivityResponseDto {
    private Long idx;
    private Long typeIdx;
    private String difficulty;
    private String target;
    private String exerciseName;
    private String description;
    private String imgUrl;
    private String videoUrl;

    public WorkoutActivityResponseDto(WorkoutActivity entity, WorkoutImg entity2, WorkoutVideo entity3){
        this.idx = entity.getIdx();
        this.typeIdx = entity.getTypeIdx();
        this.difficulty = DifficultyIdxToDifficulty(entity.getDifficultyIdx());
        this.target = TypeIdxToString(entity.getTargetIdx());
        this.exerciseName = entity.getExerciseName();
        this.description = entity.getDescription();
        this.imgUrl = entity2.getImgUrl();
        this.videoUrl = entity3.getVideoUrl();
    }

    public String TypeIdxToString(Long typeIdx){
        if(typeIdx == 1)
            return "Back";
        else if(typeIdx == 2)
            return "Leg";
        else if(typeIdx == 3)
            return "Full_Body";
        else if(typeIdx == 4)
            return "Arm";
        else
            return "Front";
    }
    public String DifficultyIdxToDifficulty(Long difficultyIdx){
        if(difficultyIdx == 1) return "Beginner";
        else if(difficultyIdx == 2) return "Intermediate";
        else return "Advanced";
    }

}
