package com.example.homekiri.media.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name="Media")
@Entity
public class MediaActivity {
    @Id
    @Column(name="idx")
    private Long idx;

    @Column(name="genreIdx")
    private Long genreIdx;

    @Column(name="mediaName")
    private String mediaName;

    @Column(name = "description")
    private String description;

    @Column(name="screeningYear")
    private Long screeningYear;

    @Column(name="country")
    private String country;

    @Column(name="actorList")
    private String actorList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idx", updatable = false, insertable = false)
    private MediaImg  mediaImg;

    @OneToMany(mappedBy = "mediaActivity")
    private List<MediaPlatform> mediaPlatformList = new ArrayList<>();

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public MediaActivity(Long idx, Long genreIdx, String mediaName, Long screeningYear, String country, String actorList, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.genreIdx = genreIdx;
        this.mediaName = mediaName;
        this.screeningYear =screeningYear;
        this.country = country;
        this.actorList = actorList;
        this.updatedAt = updatedAt;
        this.createdAt =createdAt;
    }
}
