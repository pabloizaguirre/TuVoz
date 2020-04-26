package modelo;
import java.util.*;


/**
 * Subclase proyecto infraestructura.
 * 
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 * @author Elena Cano
 */

 public class ProyectoInfraestructura extends Proyecto {
    private Imagen imagen;
    private List<Distrito> distritosAfectados;

    public ProyectoInfraestructura(String tit, String desc, double presSolicitado,
                                    ElementoColectivo creador, Imagen imagen, List<Distrito> distritosAfectados){
        super(tit, desc, presSolicitado, creador);
        this.imagen = imagen;
        this.distritosAfectados = distritosAfectados;
    }
    
    public Imagen getImagen() {
    	return imagen;
    }
    
    public List<Distrito> getDistritosAfectados() {
    	return distritosAfectados;
    }
 } 