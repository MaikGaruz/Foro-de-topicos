package com.example.demo.controller;

import com.example.demo.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    //SI SE QUIERE AGREGAR UN NUEVO CAMPO a la BD se hace mediante una migraton
    //ejemplo: alter table x add column(atributos);
    //Despues de eso actualizar la Clase - Entidad


    //Para pruebas de testing, esto no se deberia hacer de esta manera
    @Autowired
    private TopicoRepository topicoRepository;


    //Validar el objeto que se esta mandando en los metodos
    //Uno sabe que ya esta "bien" cuando sale el error 400
    //Por que el error esta nivel del payload y no del server
    @PostMapping
    public void resgitrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        System.out.println("El request llega correctamente");
        topicoRepository.save(new Topico(datosRegistroTopico));
        }


    //Para painar el resultado se usa el tipo PAGE. Retornar entonces un PAGE y no un list
    //Pero ojo, tener cuidado por que hay Interfaces que se llaman igual y al momento de referenciaralas (Por el IDE)
    //no son lo mismo
    //public List<DatosListadoTopico> listadoTopicos()
    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 10,direction = Sort.Direction.ASC) Pageable paginacion){ //El parametro Paginacion llega del Cliente
        //Analizar
        //return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); viejo1
                //.stream.map(topico -> new DatosListadoTopico(topico)).toList  viejo2 pero funciona con viejo1
    //Prueba esto : http://localhost:8082/topicos?size=10&page=0&sort=autor
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new);
    }

    //No olvidar el requestBody
    @PutMapping
    @Transactional      //Cuando termine el metodo el transaccional se libera y se ACTUALIZA LA BD
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    //DELETE LOGICO sin buenas practicas
//    @DeleteMapping("/{id}") //Se usa una Path variable
//    @Transactional      //PARA QUE TENGO EFECTO EN LA BD
//    public void eliminarTopico(@PathVariable Long id){ //Hay que indicarle a spring que es una Path...
//        Topico topico = topicoRepository.getReferenceById(id);
//        topico.desactivarTopico();
//    }

    //BUENAS PRACTICAS!!! Asi deberian ser los metodos que se retornan
    //Tambien es bueno indicar entre <> el tipo de datpo que retorna, si es que retorna
    @DeleteMapping("/{id}") //Se usa una Path variable
    @Transactional      //PARA QUE TENGO EFECTO EN LA BD
    public ResponseEntity eliminarTopico(@PathVariable Long id){ //Hay que indicarle a spring que es una Path...
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build(); //Con build se convierte a responseEntity
    }

//    Borrado TOTAL
//    public void eliminarTopico(@PathVariable Long id){ //Hay que indicarle a spring que es una Path...
//        Topico topico = topicoRepository.getReferenceById(id);
//        topicoRepository.delete(topico);
//    }

   
}
