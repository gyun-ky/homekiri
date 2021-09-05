package com.example.homekiri.like.model;

import javax.persistence.*;

@Entity
public class LikeFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;


}
