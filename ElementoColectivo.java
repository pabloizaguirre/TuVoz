import java.util.*;

/**
 * Clase ElementoColectivo. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public abstract class ElementoColectivo{
    
    private List<Proyecto> proyectosPropuestos = new ArrayList<Proyecto>();

    public void anadirAMisProyectosPropuestos(Proyecto p){
        proyectosPropuestos.add(p);
    }

    public List<Proyecto> getProyectosPropuestos(){
        return proyectosPropuestos;
    }
}