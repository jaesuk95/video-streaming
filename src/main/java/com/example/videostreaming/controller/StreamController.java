package com.example.videostreaming.controller;

import com.example.videostreaming.domain.model.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class StreamController {

    private final VideoService videoService;

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        // business logic
        return videoService.getVideo(title);
    }


}
