package dev.emanuel.movieflix.Controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String nome) {
}
