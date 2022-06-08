package com.igti.hexagonal.application.ports.outbound;

import com.igti.hexagonal.application.core.domain.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviePersistenceUseCase extends JpaRepository<Movie, Integer> {

    Movie save(Movie movie);
    List<Movie> findAll();
    void deleteById(Integer integer);
}