package modelo;
import java.io.*;

/**
 * Clase Imagen.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Imagen implements Serializable{
    private String nombre;

    public Imagen(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}