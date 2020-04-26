package modelo;
import java.util.*;
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
        super("Aprobacion de registro pendiente"+ciudadano, Aplicacion.getAplicacion().getAdministrador());
        
        this.ciudadano = ciudadano;
    }

    public Ciudadano getCiudadano() {
        return this.ciudadano;
    }
    
}