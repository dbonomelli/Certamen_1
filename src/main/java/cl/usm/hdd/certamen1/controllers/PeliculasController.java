package cl.usm.hdd.certamen1.controllers;

import cl.usm.hdd.certamen1.entities.Pelicula;
import cl.usm.hdd.certamen1.services.PeliculasService;
import cl.usm.hdd.certamen1.utils.PeliculasUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculasController {

    @Autowired
    private PeliculasService peliculasService;

    @GetMapping("/verPeliculas")
    public ResponseEntity<List<Pelicula>> get(){
        try{
            return ResponseEntity.ok(peliculasService.verPelicula());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/crearPelicula")
    public ResponseEntity<Pelicula> create(@RequestBody Pelicula pelicula){
        try{
            Pelicula newPelicula = peliculasService.crearPelicula(pelicula);
            return ResponseEntity.ok(newPelicula);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/verPeliculas/{categoria}")
    public ResponseEntity<List<Pelicula>> filtrar(@PathVariable String categoria){
        try{
            if(!PeliculasUtils.definirCategoria(categoria)){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(peliculasService.filtrarPeliculas(categoria));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
