package com.example.bibliotecaduoc.services;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.model.Prestamo;
import com.example.bibliotecaduoc.repository.LibroRepository;
import com.example.bibliotecaduoc.repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "Libro eliminado con exito";
    }

    public int totalLibrosV1() {
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }

    public List<Prestamo> getPrestamos() {
        return prestamoRepository.obtenerPrestamos();
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.guardar(prestamo);
    }

    public Prestamo getPrestamoId(int id) {
        return prestamoRepository.buscarPorId(id);
    }

    public Prestamo updatePrestamo(Prestamo prestamo) {
        return prestamoRepository.actualizar(prestamo);
    }

    public String deletePrestamo(int id) {
        prestamoRepository.eliminar(id);
        return "Prestamo eliminado con exito";
    }

    public int totalPrestamosV2() {
        return prestamoRepository.totalPrestamos();
    }
}
