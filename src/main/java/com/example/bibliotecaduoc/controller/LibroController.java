package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }
    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return libroService.getLibroId(id);
    }
    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }
}