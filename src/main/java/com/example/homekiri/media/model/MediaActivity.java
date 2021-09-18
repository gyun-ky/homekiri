package com.example.homekiri.media.model;

import com.example.homekiri.like.model.LikeMedia;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="genreIdx")
    private Genre genre;

    @Column(name="mediaName")
    private String mediaName;

    @Column(name = "description")
    private String description;

    @Column(name="screeningYear")
    private int screeningYear;

    @Column(name="country")
    private String country;

    @Column(name="actorList")
    private String actorList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "media")
    private List<LikeMedia> likeMedias = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "media")
    private List<MediaImage> mediaImages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "media")
    private List<MediaPlatform> mediaPlatformList = new ArrayList<>();

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public MediaActivity(Long idx, Genre genre, String mediaName, String description, int screeningYear, String country, String actorList, LocalDateTime updatedAt, LocalDateTime createdAt){
        this.idx = idx;
        this.genre = genre;
        this.mediaName = mediaName;
        this.description = description;
        this.screeningYear =screeningYear;
        this.country = country;
        this.actorList = actorList;
        this.updatedAt = updatedAt;
        this.createdAt =createdAt;
    }
}
