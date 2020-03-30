package padsof;
import java.util.*;

/**
 * Clase Administrador.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Administrador extends Usuario {
    
    public Administrador(String nomUs, String contr){
        super(nomUs, contr);
        Aplicacion.getAplicacion().setAdministrador(this);    
    }

    
}