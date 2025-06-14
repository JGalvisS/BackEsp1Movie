package com.example.catalog_service.service;

import com.example.catalog_service.client.IMovieClient;
import com.example.catalog_service.model.Movie;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogService {
    @Autowired
    private IMovieClient iMovieClient;


    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmpty")
    public List<Movie> catalogByGenreService (String genre, boolean throwError) {
        System.out.println("Calling movie service ...");
        return iMovieClient.getMovieByGenre(genre,throwError).getBody();
    }

    private List<Movie> findAllEmpty (String genre, boolean throwError, Throwable t){
        System.out.println("Fallback triggered: "+ t.getMessage());
        return new ArrayList<>();
    }

    public Movie saveMovieService (Movie movie){return iMovieClient.saveMovie(movie).getBody();}
}
