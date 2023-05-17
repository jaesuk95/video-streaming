package com.example.videostreaming.implementation;

import com.example.videostreaming.exception.VideoAlreadyExistsException;
import com.example.videostreaming.model.video.Video;
import com.example.videostreaming.model.video.VideoRepository;
import com.example.videostreaming.model.video.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final ResourceLoader resourceLoader;
    private static final String FORMAT="classpath:video/%s.mp4";
    private final VideoRepository videoRepository;

    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()->resourceLoader.
                getResource(String.format(FORMAT,title)))   ;
    }

    @Override
    public void saveVideo(MultipartFile file, String name) {
        if(videoRepository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(); // save the info but not the clip
        videoRepository.save(newVid);
    }

}
