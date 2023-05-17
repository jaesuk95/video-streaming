package com.example.videostreaming.model.video;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface VideoService {
    Mono<Resource> getVideo(String title);

    void saveVideo(MultipartFile file, String name) throws IOException;
}
