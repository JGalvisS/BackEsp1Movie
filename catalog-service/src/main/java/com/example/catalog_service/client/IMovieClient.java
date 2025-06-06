package com.example.catalog_service.client;

import com.example.catalog_service.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient (name = "movie-service")
public interface IMovieClient {
    @GetMapping("/api/v1/movies/genre/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre,@RequestParam boolean throwError);

    @PostMapping("/api/v1/movies/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);
}
