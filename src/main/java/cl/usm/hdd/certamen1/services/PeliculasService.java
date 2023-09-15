package cl.usm.hdd.certamen1.services;

import cl.usm.hdd.certamen1.entities.Pelicula;

import java.util.List;

public interface PeliculasService {
    List<Pelicula> verPelicula();
    Pelicula crearPelicula(Pelicula pelicula);
    List<Pelicula> filtrarPeliculas(String categoria);
}
