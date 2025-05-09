package dev.emanuel.movieflix.Controller;

import dev.emanuel.movieflix.Controller.request.MovieRequest;
import dev.emanuel.movieflix.Controller.response.MovieResponse;
import dev.emanuel.movieflix.Entity.Movie;
import dev.emanuel.movieflix.Repository.MovieRepository;
import dev.emanuel.movieflix.Service.MovieService;
import dev.emanuel.movieflix.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movieflix/movie")
public class MovieController {

    private final MovieService service;

    @PostMapping()
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        Movie savedMovie = service.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping()
    public ResponseEntity<List<MovieResponse>> findAll() {
        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList()
        );

    }
}
