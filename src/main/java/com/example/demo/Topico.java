package com.example.demo;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
//No se olvide de agregar la dependencia Validations para validar
//datos antes de enviarlos a la BD
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;

    //@Column(unique = true) Esto solo funciona a nivel bd, ver el query de migration
    private String titulo;
    private String mensaje;
    private String status;
    private String curso;
    private Date fechaDeCreacion;

    //CREADO DESOUES
    private Boolean activo;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.autor = datosRegistroTopico.autor();
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.status = datosRegistroTopico.status();
        this.curso = datosRegistroTopico.curso();
        this.fechaDeCreacion = datosRegistroTopico.fechaDeCreacion();
        this.activo = true;

    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }
    }

    public void desactivarTopico(){
        this.activo = false;
    }




    //@Embedded sirve para no referenciar a una clase como una tabla
}
