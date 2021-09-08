package com.example.homekiri.media.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="Media_Platform")
@Entity
public class MediaPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mediaIdx")
    private MediaActivity media;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platformIdx")
    private Platform platform;


    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;


    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public MediaPlatform(Long idx, MediaActivity media, Platform platform , LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.media = media;
        this.platform = platform;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
