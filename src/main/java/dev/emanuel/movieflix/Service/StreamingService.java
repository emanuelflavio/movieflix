package dev.emanuel.movieflix.Service;

import dev.emanuel.movieflix.Entity.Streaming;
import dev.emanuel.movieflix.Repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<Streaming> findAll() {
        return repository.findAll();
    }

    public Optional<Streaming> findById(Long id) {
        return repository.findById(id);
    }

    public Streaming saveStreaming(Streaming streaming) {
        return repository.save(streaming);
    }
    public void deleteStreaming(Long id) {
        repository.deleteById(id);
    }
}
