package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

//Se crea otro DTO para mostrar cosas diferentes
public record DatosListadoTopico(
        Long id,
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
    public DatosListadoTopico(Topico topico){
        //La manera tradiconal de guardar los datos no funciono, investigar por k
        //Constructor sobrecargado
        //utiliza la llamada this(...) para reutilizar el constructor principal.
        this(topico.getId(), topico.getAutor(),topico.getTitulo(),topico.getMensaje(),topico.getStatus(),topico.getCurso(),topico.getFechaDeCreacion());
    }

}
