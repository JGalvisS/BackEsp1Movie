package com.example.catalog_service.controller;

import com.example.catalog_service.client.IMovieClient;
import com.example.catalog_service.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private IMovieClient iMovieClient;

    @GetMapping("catalog/{genre}")
    public ResponseEntity <List<Movie>> getCatalogByGenre (@PathVariable String genre){
        return  iMovieClient.getMovieByGenre(genre);
    }

    @PostMapping("catalog/moviesave")
    public ResponseEntity <Movie> seveMovie(@RequestBody Movie movie){
        return iMovieClient.saveMovie(movie);
    }
}
