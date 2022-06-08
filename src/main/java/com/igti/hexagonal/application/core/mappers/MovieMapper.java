package com.igti.hexagonal.application.core.mappers;

import com.igti.hexagonal.application.core.domain.Movie;
import com.igti.hexagonal.application.core.dto.MovieDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    MovieDTO moviesToMoviesDTO(Movie movie);
    Movie moviesDTOToMovies(MovieDTO dto);
    List<MovieDTO> moviesListToMoviesDTOs(List<Movie> moviesList);
    Movie moviesToMovies(Movie movie);
}