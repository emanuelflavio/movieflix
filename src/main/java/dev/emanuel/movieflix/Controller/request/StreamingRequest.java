package dev.emanuel.movieflix.Controller.request;

import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(@NotEmpty(message = "Nome do Streaming é obrigatorio!") String nome) {
}
