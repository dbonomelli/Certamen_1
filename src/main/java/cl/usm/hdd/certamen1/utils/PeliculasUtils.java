package cl.usm.hdd.certamen1.utils;

import java.util.stream.Stream;

public class PeliculasUtils {
    public static boolean definirCategoria(String categoria) {
        String[] listado = {"Menor_edad", "Adolescentes", "Mayor"};
        return Stream.of(listado).anyMatch(s -> s.equalsIgnoreCase(categoria));
    }
}
