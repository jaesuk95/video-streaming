package com.example.videostreaming.implementation;

import com.example.videostreaming.domain.model.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final ResourceLoader resourceLoader;
    private static final String FORMAT="classpath:video/%s.mp4";

    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()->resourceLoader.
                getResource(String.format(FORMAT,title)))   ;
    }

}
