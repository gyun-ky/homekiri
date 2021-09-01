package com.example.homekiri.recommendation.Dto.ActivityRecommendDto;

import com.example.homekiri.recommendation.model.activity.Info.WorkoutImg;
import com.example.homekiri.recommendation.model.activity.Info.WorkoutVideo;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import lombok.Getter;

@Getter
public class WorkoutRecommendDto {
    private Long idx;
    private String type;
    private String exerciseName;
    private String imgUrl;

    public WorkoutRecommendDto(WorkoutActivity entity, WorkoutImg entity2){
        this.idx = entity.getIdx();
        this.type = TypeIdxToType(entity.getTypeIdx());
        this.exerciseName = entity.getExerciseName();
        this.imgUrl = entity2.getImgUrl();
    }
    public String TypeIdxToType(Long typeIdx){
        if(typeIdx == 1) return "요가";
        else if(typeIdx == 2) return "헬스";
        else return "기타";
    }
}
