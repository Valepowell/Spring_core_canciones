package com.valeskapowell.servicios;

import com.valeskapowell.modelos.Artista;
import com.valeskapowell.repositorios.RepositorioArtistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorio;

    public List<Artista> obtenerTodosLosArtistas() {
        return repositorio.findAll();
    }

    public Artista obtenerArtistaPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista) {
        return repositorio.save(artista);
    }
}
