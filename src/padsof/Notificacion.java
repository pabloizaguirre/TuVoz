package padsof;
import java.util.*;
/**
 * Clase notificación.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class Notificacion {
    
    private String textoNotificacion;
    private Usuario usuario;
 
    public Notificacion (String texto, Usuario usuario) {
        this.textoNotificacion = texto;
        this.usuario = usuario;
        usuario.anadirNotificacion(this);
    }
    

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTextoNotificacion() {
        return this.textoNotificacion;
    }

    public void setTextoNotificacion(String textoNotificacion) {
        this.textoNotificacion = textoNotificacion;
    }

}