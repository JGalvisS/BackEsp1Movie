package com.example.catalog_service.controller;

import com.example.catalog_service.model.Movie;
import com.example.catalog_service.service.CatalogService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("catalog/{genre}")
    @Retry(name = "movies")
    public ResponseEntity <List<Movie>> getCatalogByGenre (@PathVariable String genre, @RequestParam (defaultValue = "false") boolean throwError) throws Exception{
            return ResponseEntity.ok(catalogService.catalogByGenreService(genre,throwError));
    }

    @PostMapping("catalog/moviesave")
    public ResponseEntity <Movie> postSaveMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(catalogService.saveMovieService(movie));
    }
}
