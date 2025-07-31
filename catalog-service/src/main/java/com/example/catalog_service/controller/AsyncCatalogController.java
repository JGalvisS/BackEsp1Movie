package com.example.catalog_service.controller;

import com.example.catalog_service.model.Movie;
import com.example.catalog_service.queue.MovieSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncCatalogController {

    private final MovieSender sender;

    public AsyncCatalogController (MovieSender sender){
        this.sender= sender;
    }
    @PostMapping("catalog/moviesave-async")
    public ResponseEntity<Movie> asyncSaveMovie(@RequestBody Movie movie){
        sender.send(movie);
        return ResponseEntity.noContent().build();
    }
}
