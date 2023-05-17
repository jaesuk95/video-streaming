package com.example.videostreaming.model.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String userId;
    private String directory;
    private boolean isPrivate;
    private boolean isPaid;

    public Video(String name, String userId, String directory, boolean isPrivate, boolean isPaid) {
        this.name = name;
        this.userId = userId;
        this.directory = directory;
        this.isPrivate = isPrivate;
        this.isPaid = isPaid;
    }
}
