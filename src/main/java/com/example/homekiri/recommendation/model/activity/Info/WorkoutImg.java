package com.example.homekiri.recommendation.model.activity.Info;

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
@Table(name="MediaImage")
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
