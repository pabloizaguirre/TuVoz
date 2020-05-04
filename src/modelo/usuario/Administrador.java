package modelo.usuario;
import java.util.*;
import java.io.*;

/**
 * Clase Administrador.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Administrador extends Usuario implements Serializable {
    public Administrador() {
    	super("Admin", "123");
    }
    public Administrador(String nomUs, String contr){
        super(nomUs, contr);  
    }

    
}