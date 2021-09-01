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
@Table(name="Media_Platform")
@Entity
public class MediaPlatform {
    @Id
    @Column(name ="idx")
    private Long idx;

    @Column(name = "mediaIdx")
    private Long mediaIdx;

    @Column(name = "platformIdx")
    private String platformIdx;


    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public MediaPlatform(Long idx, Long mediaIdx, String platformIdx , LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.mediaIdx = mediaIdx;
        this.platformIdx = platformIdx;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
