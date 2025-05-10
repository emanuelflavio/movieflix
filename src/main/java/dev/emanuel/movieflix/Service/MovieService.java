package dev.emanuel.movieflix.Service;

import dev.emanuel.movieflix.Entity.Category;
import dev.emanuel.movieflix.Entity.Movie;
import dev.emanuel.movieflix.Entity.Streaming;
import dev.emanuel.movieflix.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Movie> update(Long id, Movie movieUpdate) {
        Optional<Movie> optMovie = repository.findById(id);
        if (optMovie.isPresent()) {
            List<Category> categories = this.findCategories(movieUpdate.getCategories());
            List<Streaming> streamings = this.findStreamings(movieUpdate.getStreamings());

            Movie movie = optMovie.get();
            movie.setTitle(movieUpdate.getTitle());
            movie.setDescription(movieUpdate.getDescription());
            movie.setRating(movieUpdate.getRating());
            movie.setReleaseDate(movieUpdate.getReleaseDate());

            // para lista não pode setar direto tem que limpar depois add tudo
            movie.getCategories().clear();
            movie.getCategories().addAll(categories);
            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            repository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public List<Movie> findByCategories(Long categoryId) {
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> {
            categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
        });
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> {
            streamingService.findById(streaming.getId()).ifPresent(streamingFound::add);
        });
        return streamingFound;
    }
}
