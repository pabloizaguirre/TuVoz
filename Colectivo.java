import java.util.*;

/**
 * Clase proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

/**
 * 
 */
public class Colectivo extends ElementoColectivo {

    Private String titulo;
    Private Ciudadano representante;
    Private ArrayList<ElementoColectivo> elementos; 
    Private ArrayList<Proyecto> proyectos;
    


    public Colectivo(String tit, Ciudadano rep){
        titulo = tit;
        representante = rep;
    }


    public Bool unirseAColectivo(Ciudadano miembro){
        if (elementos.contains(miembro)){
            return false;
        }
        
        elementos.add(miembro);
        return true;
    }




    
}