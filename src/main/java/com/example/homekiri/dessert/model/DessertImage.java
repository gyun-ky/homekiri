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

    @Column(name = "dessertIdx")
    private Long dessertIdx;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "dessertImage")
    private DessertActivity dessertActivity;

    @Column(name="updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public DessertImage(Long idx, Long dessertIdx, String description, String imgUrl, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.idx = idx;
        this.dessertIdx = dessertIdx;
        this.imgUrl =  imgUrl;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
