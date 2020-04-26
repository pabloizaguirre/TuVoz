package modelo;
import java.util.*;
import java.io.*;

/**
 * Clase notificación de proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class NotificacionProyecto extends Notificacion {
    private Proyecto proyecto;

    public NotificacionProyecto(Proyecto p, Usuario usuario) {
        super("El proyecto " + p.getTitulo() + " ha cambiado a estado: " + p.getEstado().toString(),usuario);
        proyecto = p;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

}