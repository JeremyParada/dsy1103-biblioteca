package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Prestamo;
import com.example.bibliotecaduoc.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.getPrestamos();
    }

    @PostMapping
    public Prestamo agregaPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.savePrestamo(prestamo);
    }

    @GetMapping("{id}")
    public Prestamo buscarPrestamo(@PathVariable int id) {
        return prestamoService.getPrestamoId(id);
    }

    @PutMapping("{id}")
    public Prestamo actualizarPrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        prestamo.setId_prestamo(id);
        return prestamoService.updatePrestamo(prestamo);
    }

    @DeleteMapping("{id}")
    public String eliminarPrestamo(@PathVariable int id) {
        return prestamoService.deletePrestamo(id);
    }

    @GetMapping("/total")
    public int totalPrestamosV2(){
        return prestamoService.totalPrestamosV2();
    }
}