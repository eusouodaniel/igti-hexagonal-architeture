package com.igti.hexagonal.adapters.outbound;

import com.igti.hexagonal.application.core.mappers.MovieMapper;
import com.igti.hexagonal.application.ports.inbound.MovieUseCase;
import com.igti.hexagonal.application.ports.outbound.MoviePersistenceUseCase;
import com.igti.hexagonal.application.core.domain.Movie;
import com.igti.hexagonal.application.core.dto.MovieDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieUseCase {

    private static final String EXCEPTION_MESSAGE = "Movie not found";

    @Autowired
    private MoviePersistenceUseCase moviePersistenceUseCase;

    @Override
    public MovieDTO create(MovieDTO dto) {
        Movie movie = MovieMapper.INSTANCE.moviesDTOToMovies(dto);
        this.moviePersistenceUseCase.save(movie);

        return dto;
    }

    @Override
    public List<MovieDTO> list() {
        return MovieMapper.INSTANCE.moviesListToMoviesDTOs(this.moviePersistenceUseCase.findAll());
    }

    @Override
    public MovieDTO remove(int id) throws Exception {
        Optional<Movie> movieOpt = this.moviePersistenceUseCase.findById(id);
        if(!movieOpt.isPresent())
             throw new Exception(EXCEPTION_MESSAGE);
        this.moviePersistenceUseCase.deleteById(id);

        return MovieMapper.INSTANCE.moviesToMoviesDTO(movieOpt.get());
    }

    @Override
    public MovieDTO update(MovieDTO dto, int id) throws Exception {
        Optional<Movie> movieOpt = this.moviePersistenceUseCase.findById(id);
        if(!movieOpt.isPresent())
            throw new Exception(EXCEPTION_MESSAGE);
        Movie movie = this.moviePersistenceUseCase
                .save(MovieMapper.INSTANCE.moviesToMovies(movieOpt.get()));

        return MovieMapper.INSTANCE.moviesToMoviesDTO(movie);
    }
}