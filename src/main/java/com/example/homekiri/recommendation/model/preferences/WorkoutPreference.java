package com.example.homekiri.recommendation.model.preferences;

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
@Table(name = "ExercisePreference")
public class WorkoutPreference {


    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "health")
    private Long horror;

    @Column(name = "yoga")
    private Long romance;

    @Column(name = "difficulty")
    private Long comedy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

}
