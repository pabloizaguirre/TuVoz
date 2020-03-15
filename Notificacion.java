import java.util.*;
/**
 * Clase notificación.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class Notificacion {
    private Ciudadano ciudadano;
    private String textoNotificacion;
 
    Notificacion (String texto, Ciudadano ciudadano) {
        this.textoNotificacion = texto;
        this.ciudadano = ciudadano;
    }
    

    public Ciudadano getCiudadano() {
        return this.ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public String getTextoNotificacion() {
        return this.textoNotificacion;
    }

    public void setTextoNotificacion(String textoNotificacion) {
        this.textoNotificacion = textoNotificacion;
    }

}