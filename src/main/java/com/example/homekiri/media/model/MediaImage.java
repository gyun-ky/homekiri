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
public class MediaImage {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mediaIdx")
    private MediaActivity media;

    @Column(name = "description")
    private String description;

    @Column(name = "imgUrl")
    private String imgUrl;

//    @OneToOne(mappedBy = "mediaImg")
//    private MediaActivity mediaActivity;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public MediaImage(Long idx, MediaActivity media, String description, String imgUrl, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.media = media;
        this.description = description;
        this.imgUrl = imgUrl;
        this.updatedAt = updatedAt;
        this.createdAt =createdAt;
    }
}
