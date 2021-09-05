package com.example.homekiri.model.Exersice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="Exercise")
@Entity
public class WorkoutActivity {
    @Id
    @Column(name="idx")
    private Long idx;

    @Column(name="typeIdx")
    private Long typeIdx;

    @Column(name="difficultyIdx")
    private Long difficultyIdx;

    @Column(name="targetIdx")
    private Long targetIdx;

    @Column(name="exerciseName")
    private String exerciseName;

    @Column(name="description")
    private String description;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private WorkoutImg workoutImg;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private WorkoutVideo workoutVideo;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;


    @Builder
    public WorkoutActivity(Long idx, Long typeIdx, Long difficultyIdx, Long targetIdx, String exerciseName, String description, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.typeIdx = typeIdx;
        this.difficultyIdx = difficultyIdx;
        this.targetIdx  =targetIdx;
        this.exerciseName = exerciseName;
        this.description = description;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
