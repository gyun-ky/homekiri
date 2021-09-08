package com.example.homekiri.exercise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="ExerciseImage")
@Entity
public class WorkoutImg {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "exerciseIdx")
    private Long exerciseIdx;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private WorkoutActivity workoutActivity;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public WorkoutImg(Long idx, Long exerciseIdx, String imgUrl, String description, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.exerciseIdx = exerciseIdx;
        this.imgUrl = imgUrl;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
