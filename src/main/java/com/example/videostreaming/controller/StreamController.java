package com.example.videostreaming.controller;

import com.example.videostreaming.model.video.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class StreamController {

    private final VideoService videoService;

    @GetMapping(value = "/video/{title}", produces = "video/mp4")
//    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
    public Mono<Resource> getVideos(@PathVariable String title) {
//        System.out.println("range in bytes() : " + range);
        // business logic
        return videoService.getVideo(title);
    }



    @PostMapping("/video/upload")
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {

        if (!file.isEmpty()) {
            try {
                videoService.saveVideo(file, name);
                return ResponseEntity.ok("Video saved successfully.");
            } catch (Exception e) {
                // Handle the exception appropriately
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the video.");
            }
        }

        return ResponseEntity.badRequest().body("Video file is missing or empty.");
    }



}
