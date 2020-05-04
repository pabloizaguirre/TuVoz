package modelo.notificacion.ciudadano;
import java.util.*;

import modelo.Ciudadano;
import modelo.aplicacion.Aplicacion;
import modelo.notificacion.Notificacion;

import java.io.*;

/**
 * Clase notificación de ciudadano.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class NotificacionCiudadano extends Notificacion {
    private Ciudadano ciudadano;


    public NotificacionCiudadano(Ciudadano ciudadano) {
        super("Aprobacion de registro "+ ciudadano.getNombreUsuario() +" pendiente ", Aplicacion.getAplicacion().getAdministrador());
        
        this.ciudadano = ciudadano;
    }

    public Ciudadano getCiudadano() {
        return this.ciudadano;
    }
    
}