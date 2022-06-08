package com.igti.hexagonal.application.ports.inbound;

import com.igti.hexagonal.application.core.dto.MovieDTO;

import java.util.List;

public interface MovieUseCase {

    MovieDTO create(MovieDTO dto);
    List<MovieDTO> list();
    MovieDTO remove(int id) throws Exception;
    MovieDTO update(MovieDTO dto, int id) throws Exception;
}