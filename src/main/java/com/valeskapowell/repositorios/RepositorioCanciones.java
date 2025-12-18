package com.valeskapowell.repositorios; 
import com.valeskapowell.modelos.Cancion; 
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository; 

@Repository 
public interface RepositorioCanciones extends 
CrudRepository<Cancion, Long> {
}