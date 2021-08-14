package com.example.homekiri.dashboard.Dto;

import com.example.homekiri.dashboard.model.WorkoutTrend;
import lombok.Getter;

@Getter
public class WorkoutTrendListResponseDto {

    private Long idx;
    private Long workoutIdx;
    private String workoutName;

    public WorkoutTrendListResponseDto(WorkoutTrend entity){
        this.idx = entity.getIdx();
        this.workoutIdx = entity.getWorkoutIdx();
        this.workoutName = entity.getWorkoutName();
    }
}
