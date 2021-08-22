package com.example.homekiri.recommendation.model.activity.Info;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="MediaImage")
@Entity
public class WorkoutVideo {
    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "exerciseIdx")
    private Long exerciseIdx;

    @Column(name = "videoUrl")
    private String videoUrl;

    @Column(name = "description")
    private String description;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    public WorkoutVideo(Long idx, Long exerciseIdx, String videoUrl, String description, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.exerciseIdx = exerciseIdx;
        this.videoUrl = videoUrl;
        this.description = description;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
