package com.example.homekiri.story.model;

import com.example.homekiri.config.Auditable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StoryCategory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private String categoryName;

    @OneToMany(mappedBy = "storyCategory")
    private List<Story> stories = new ArrayList<Story>();

}
