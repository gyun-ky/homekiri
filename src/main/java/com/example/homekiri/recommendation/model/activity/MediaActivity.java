package com.example.homekiri.recommendation.model.activity;

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
@Table(name="Media")
@Entity
public class MediaActivity {
    @Column(name="idx")
    @Id
    private Long idx;

    @Column(name="genreIdx")
    private Long genreIdx;

    @Column(name="mediaName")
    private String mediaName;

    @Column(name="screeningYear")
    private Long screeningYear;

    @Column(name="country")
    private String country;

    @Column(name="actorList")
    private String actorList;

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
