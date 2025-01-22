package com.example.Biblioteca.controlador;


import com.example.Biblioteca.modelo.Libro;
import com.example.Biblioteca.servicios.LibroServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroControlador {

    @Autowired
    private LibroServicios servicios;

    // Obtener todos los libros
    @GetMapping
    public List<Libro> obtenerTodos() {
        return servicios.obtenerTodos();
    }

    // Crear un nuevo libro
    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return servicios.guardarLibro(libro);
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibro(@PathVariable Long id) {
        Libro libro = servicios.obtenerPorId(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        servicios.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}
