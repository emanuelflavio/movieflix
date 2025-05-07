package dev.emanuel.movieflix.mapper;

import dev.emanuel.movieflix.Controller.request.StreamingRequest;
import dev.emanuel.movieflix.Controller.response.StreamingResponse;
import dev.emanuel.movieflix.Entity.Streaming;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming
                .builder()
                .name(streamingRequest.nome())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .nome(streaming.getName())
                .build();
    }

}
