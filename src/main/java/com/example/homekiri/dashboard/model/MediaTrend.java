package com.example.homekiri.dashboard.model;

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
@Entity
//@Builder
@Table(name="MediaTrend")
public class MediaTrend {

    @Id
    @Column(name = "idx")
    private Long idx;

    @Column(name = "mediaIdx")
    private String mediaIdx;

    @Column(name = "mediaName")
    private String mediaName;

    @Column(name="ranking")
    private int ranking;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;
}
