package com.example.demo;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
    @NotNull
    Long id,
    String mensaje,
    String status
) {
}
