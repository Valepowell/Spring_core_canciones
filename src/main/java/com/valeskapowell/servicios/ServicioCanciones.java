package com.valeskapowell.servicios;

import com.valeskapowell.modelos.Cancion;
import com.valeskapowell.repositorios.RepositorioCanciones;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ServicioCanciones {

    private final RepositorioCanciones repositorio;

    public ServicioCanciones(RepositorioCanciones repositorio) {
        this.repositorio = repositorio;
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        return StreamSupport.stream(repositorio.findAll().spliterator(), false)
                .toList();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return repositorio.save(cancion);
    }
//  ACTUALIZAR
    public Cancion actualizaCancion(Cancion cancion) {
        return repositorio.save(cancion);
    }

    
// ELIMINAR 
    public void eliminarCancion(Long id) {
        repositorio.deleteById(id);
    }   
}
