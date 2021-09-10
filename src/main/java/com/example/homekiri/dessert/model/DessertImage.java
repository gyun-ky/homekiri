package com.example.homekiri.dessert.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name="DessertImage")
@Entity
public class DessertImage {

    @Id
    @Column(name ="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dessertIdx")
    private DessertActivity dessertActivity;

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
    public DessertImage(Long idx, String description, String imgUrl, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.idx = idx;
        this.imgUrl =  imgUrl;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}