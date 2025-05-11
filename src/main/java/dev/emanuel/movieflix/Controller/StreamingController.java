package dev.emanuel.movieflix.Controller;

import dev.emanuel.movieflix.Controller.request.StreamingRequest;
import dev.emanuel.movieflix.Controller.response.StreamingResponse;
import dev.emanuel.movieflix.Entity.Category;
import dev.emanuel.movieflix.Entity.Streaming;
import dev.emanuel.movieflix.Service.StreamingService;
import dev.emanuel.movieflix.mapper.CategoryMapper;
import dev.emanuel.movieflix.mapper.StreamingMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;


    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreaming(){
        List<StreamingResponse> streaming = service.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(streaming);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request) {
        Streaming streaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = service.saveStreaming(streaming);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingById(@PathVariable Long id) {
        return service.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id) {
        service.deleteStreaming(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
