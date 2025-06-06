package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author vaninagodoy
 * @author JGalvisS
 */

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/genre/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre, @RequestParam boolean throwError){
        if(throwError){
            throw new RuntimeException("Simulated error from movie-service");
        }
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }

    @GetMapping("/name/{name}")
    ResponseEntity <Optional<Movie>>getMovieByName(@PathVariable String name){
        return  ResponseEntity.ok().body( movieService.findByName(name));
    }

    @DeleteMapping("/{id}")
    ResponseEntity <String>deleteMovie(@PathVariable Long id){
        movieService.deleteById(id);
        String respuesta = "La pelicula fue eliminada";
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity <String> updateMovie(@RequestBody Movie movie){
        Optional<Movie> findMovie =movieService.findById(movie.getId());
        String response = null;
        if(findMovie.isPresent()){movieService.update(movie);
            response= "ID Movie" + movie.getId()+" has been updated successful";
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else { response = "Movie hasnt updated";
            return new ResponseEntity<>(response,HttpStatus.OK);}
    }

    @GetMapping("/{id}")
    ResponseEntity <Optional<Movie>> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(movieService.findById(id));
    }
}
