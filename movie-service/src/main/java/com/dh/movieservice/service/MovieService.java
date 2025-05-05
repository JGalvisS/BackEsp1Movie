package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author vaninagodoy
 * @author JGalvisS
 */

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> findByName(String name){  return movieRepository.findByName(name); }

    public void deleteById(long id){movieRepository.deleteById(id);}

    public Optional<Movie> findById (Long id){return movieRepository.findById(id);}

    public void update (Movie movie){ movieRepository.save(movie);}

}
