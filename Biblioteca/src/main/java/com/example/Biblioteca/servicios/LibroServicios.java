package com.example.Biblioteca.servicios;

import com.example.Biblioteca.modelo.Libro;
import com.example.Biblioteca.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicios {

    @Autowired
    private LibroRepositorio repositorio;

    // Obtener todos los libros
    public List<Libro> obtenerTodos() {
        return repositorio.findAll();
    }

    // Guardar un nuevo libro
    public Libro guardarLibro(Libro libro) {
        return repositorio.save(libro);
    }

    // Obtener un libro por ID
    public Libro obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    // Actualizar un libro existente
    public Libro actualizarLibro(Long id, Libro libroDetalle) {
        Libro libro = repositorio.findById(id).orElse(null);
        if (libro != null) {
            libro.setTitulo(libroDetalle.getTitulo());
            libro.setAutor(libroDetalle.getAutor());
            return repositorio.save(libro);
        }
        return null;
    }

    // Eliminar un libro por ID
    public void eliminarLibro(Long id) {
        repositorio.deleteById(id);
    }
}