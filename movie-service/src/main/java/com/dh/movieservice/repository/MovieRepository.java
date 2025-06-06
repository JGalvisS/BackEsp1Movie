package com.dh.movieservice.repository;

import com.dh.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author vaninagodoy
 * @author JGalvisS
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    Optional<Movie> findByName(String name) ;
}
