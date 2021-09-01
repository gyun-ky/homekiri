package com.example.homekiri.recommendation.model.preferences;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ExercisePreference")
public class WorkoutPreference {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "health")
    private Long health;

    @Column(name = "yoga")
    private Long yoga;

    @Column(name = "difficulty")
    private Long difficulty;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

}
