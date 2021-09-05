package com.example.homekiri.story.model;

import com.example.homekiri.user.model.User;

import javax.persistence.*;

@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="storyCategoryIdx")
    private StoryCategory storyCategory;

}
