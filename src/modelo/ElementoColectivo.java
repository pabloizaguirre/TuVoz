package modelo;
import java.util.*;
import java.io.*;

/**
 * Clase ElementoColectivo. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public interface ElementoColectivo extends Serializable{
    public List<Proyecto> getProyectosPropuestos();

    public List<Proyecto> getProyectosApoyados();

    /**
     * Método para añadir un proyecto a la lista de proyectos propuestos
     * 
     * @param p Proyecto que deseamos añadir a la lista
     * 
     * 
     */
    public void anadirAMisProyectosPropuestos(Proyecto p);

    /**
     * Metodo para añadir un proyecto a la lista de proyectos apoyados
     * 
     * @param p Proyecto que deseamos añadir a la lista
     */
    public void anadirAMisProyectosApoyados(Proyecto p);


    /**
     * Metodo para eliminar un proyecto de la lista de proyectos apoyados
     * 
     * @param p Proyecto que deseamos eliminar de la lista
     */
    public void eliminarDeMisProyectosApoyados(Proyecto p);
}