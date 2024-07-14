package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

//ESTE ES UN DTO
//El intermediario entre la base de datos y el controller
//Aqui se hacen las validaciones
public record DatosRegistroTopico(

//        @NotBlank se usa para validar cadenas (String),
//        asegurándose de que no sean nulas y no estén en blanco.
//        @NotNull que no sean nulos, por ejemplo para los objetos
        @NotBlank
        String autor,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
                @Pattern(regexp = "\\d{3}") //\\d Representa cualquier dígito (0-9).
        String status,
        @NotBlank
        String curso,
        @NotNull
        @Valid  //Se usa para los datos no primitivos
        Date fechaDeCreacion
) {
}
