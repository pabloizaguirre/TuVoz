package src;
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
    private List<Proyecto> proyectosApoyados = new ArrayList<Proyecto>();

    public List<Proyecto> getProyectosPropuestos(){
        return this.proyectosPropuestos;
    }

    public List<Proyecto> getProyectosApoyados(){
        return this.proyectosApoyados;
    }

    /**
     * Método para añadir un proyecto a la lista de proyectos propuestos
     * 
     * @param p Proyecto que deseamos añadir a la lista
     * 
     * @return void
     */
    public void anadirAMisProyectosPropuestos(Proyecto p){
        if(proyectosPropuestos.contains(p)) {
            return;
        }
        proyectosPropuestos.add(p);
        return;
    }

    /**
     * Metodo para añadir un proyecto a la lista de proyectos apoyados
     * 
     * @param p Proyecto que deseamos añadir a la lista
     */
    public void anadirAMisProyectosApoyados(Proyecto p){
        if(proyectosApoyados.contains(p)){
            return;
        }
        proyectosApoyados.add(p);
        return;
    }

    public void eliminarDeMisProyectosApoyados(Proyecto p){
        if(proyectosApoyados.contains(p)){
            proyectosApoyados.remove(p);
            return;
        }
        return;
    }
}