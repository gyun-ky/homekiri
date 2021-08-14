package com.example.homekiri.dashboard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
//@Builder
@Table(name = "WorkoutTrend")
public class WorkoutTrend{
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "workoutIdx")
    private Long workoutIdx;

    @Column(name = "workoutName")
    private String workoutName;

    @Column(name = "ranking")
    private int ranking;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;
}
