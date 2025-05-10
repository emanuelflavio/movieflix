package dev.emanuel.movieflix.Repository;

import dev.emanuel.movieflix.Entity.Category;
import dev.emanuel.movieflix.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> category);
}
