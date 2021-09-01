package com.example.homekiri.survey.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "ExercisePreference")
public class ExerciseSurvey {
    @Id
    @Column(name = "idx")
    @GeneratedValue
    private Long idx;

    private int difficulty;

    private int health;

    private int yoga;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;
}
