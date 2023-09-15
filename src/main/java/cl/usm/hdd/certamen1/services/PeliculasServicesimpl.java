package cl.usm.hdd.certamen1.services;

import cl.usm.hdd.certamen1.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculasServicesimpl implements PeliculasService{
    private List<Pelicula> peliculas = new ArrayList<>();
    @Override
    public List<Pelicula> verPelicula() {
        return peliculas;
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        return pelicula;
    }

    @Override
    public List<Pelicula> filtrarPeliculas(String categoria) {
        if(categoria.equalsIgnoreCase("Menor_edad")){
            return peliculas.stream().filter(s->s.getEdadMin() <= 15).collect(Collectors.toList());
        } else if (categoria.equalsIgnoreCase("Adolescentes")) {
            return peliculas.stream().filter(s->s.getEdadMin() >15 && s.getEdadMin() < 18).collect(Collectors.toList());
        } else if (categoria.equalsIgnoreCase("Mayor")){
            return peliculas.stream().filter(s->s.getEdadMin() >= 18).collect(Collectors.toList());
        }
        return peliculas;
    }
}
