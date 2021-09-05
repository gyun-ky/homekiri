package com.example.homekiri.media.model;

import lombok.Builder;
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
public class MediaImg {
    @Id
    @Column(name = "idx")
    private Long Idx;

    @Column(name = "mediaIdx")
    private Long mediaIdx;

    @Column(name = "description")
    private String description;

    @Column(name = "imgUrl")
    private String imgUrl;

    @OneToOne(mappedBy = "mediaImg")
    private MediaActivity mediaActivity;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public MediaImg(Long idx, Long mediaIdx, String description, String imgUrl, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.Idx = idx;
        this.mediaIdx = mediaIdx;
        this.description = description;
        this.imgUrl = imgUrl;
        this.updatedAt = updatedAt;
        this.createdAt =createdAt;
    }
}
