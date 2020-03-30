package padsof;
import java.util.*;
/**
 * Subclase proyecto infraestructura.
 * 
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

 public class ProyectoInfraestructura extends Proyecto {
    private Imagen imagen;

    public ProyectoInfraestructura(String tit, String desc, double presSolicitado,
                                    ElementoColectivo creador, Imagen imagen){
        super(tit, desc, presSolicitado, creador, ProjectKind.infraestructura);
        this.imagen = imagen;
    }
 } 