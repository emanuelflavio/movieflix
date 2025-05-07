package dev.emanuel.movieflix.Repository;

import dev.emanuel.movieflix.Entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
