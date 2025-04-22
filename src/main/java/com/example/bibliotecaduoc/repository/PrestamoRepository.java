package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public List<Prestamo> obtenerPrestamos() {
        return listaPrestamos;
    }

    public Prestamo buscarPorId(int id){
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId_prestamo() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public Prestamo guardar(Prestamo prestamo){
        listaPrestamos.add(prestamo);
        return prestamo;
    }

    public Prestamo actualizar(Prestamo prestamo){
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getId_prestamo() == prestamo.getId_prestamo()) {
                listaPrestamos.set(i, prestamo);
                return prestamo;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        listaPrestamos.removeIf(x -> x.getId_prestamo() == id);
    }

    public int totalPrestamos(){
        return listaPrestamos.size();
    }
}