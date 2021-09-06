package com.example.homekiri.survey.model;

import com.example.homekiri.survey.Dto.ExerciseRequestDto;
import com.example.homekiri.user.model.User;
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

    @OneToOne(mappedBy = "user")
    @Column(name = "userIdx")
    private User user;

    private int difficulty;
    private int health;
    private int yoga;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    public ExerciseSurvey() {
    }

    public ExerciseSurvey(ExerciseRequestDto exerciseRequestDto){
        this.difficulty = exerciseRequestDto.getDifficulty();
        this.health = exerciseRequestDto.getHealth();
        this.yoga = exerciseRequestDto.getYoga();
    }
}