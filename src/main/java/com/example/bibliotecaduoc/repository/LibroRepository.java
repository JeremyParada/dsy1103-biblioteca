package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository () {
        listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
        listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice 2 ESCUELA DE ADMINISTRACIÓN Y NEGOCIOS Hall", 2017, "Robert C. Martin"));
        listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall",
        2008, "Robert C. Martin"));}

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    
    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }
            Libro libro1 = new Libro();
            libro1.setId(lib.getId());
            libro1.setTitulo(lib.getTitulo());
            libro1.setAutor(lib.getAutor());
            libro1.setFechaPublicacion(lib.getFechaPublicacion());
            libro1.setEditorial(lib.getEditorial());
            libro1.setIsbn(lib.getIsbn());

            listaLibros.set(idPosicion, libro1);
            return libro1;
        }
    public void eliminar(int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
    
    int idPosicion = 0;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
    
        if (idPosicion > 0){
            listaLibros.remove(idPosicion);
        }

        listaLibros.removeIf(x -> x.getId() == id);
    }
    
    public int totalLibros(){
        return listaLibros.size();
    
    }

}