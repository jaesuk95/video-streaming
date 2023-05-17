package com.example.videostreaming.model.video;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
    boolean existsByName(String name);
}
