package com.igti.hexagonal.adapters.inbound;

import com.igti.hexagonal.adapters.outbound.MovieServiceImpl;
import com.igti.hexagonal.application.core.dto.MovieDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping
    public List<MovieDTO> list() {
        return this.movieService.list();
    }

    @PostMapping
    public void create(@RequestBody MovieDTO request) {
        this.movieService.create(request);
    }

    @PutMapping("/{id}")
    public MovieDTO update(@RequestBody MovieDTO request, @PathVariable int id) throws Exception {
        return this.movieService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public MovieDTO remove(@PathVariable int id) throws Exception {
        return this.movieService.remove(id);
    }
}