package cl.usm.hdd.certamen1.entities;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

    private String nombre;
    private String nombreAbrv;
    private int edadMin;
    private String genero;

}
