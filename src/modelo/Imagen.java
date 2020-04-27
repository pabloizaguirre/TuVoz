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
    private String path;

    public Imagen(String path, String nombre){
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public String getPath() {
    	return path;
    }
}