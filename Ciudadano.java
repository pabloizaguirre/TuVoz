import java.util.*;

/**
 * Clase Ciudadano. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Ciudadano extends Usuario {

    


    public Colectivo(String tit, Ciudadano rep){
        titulo = tit;
        representante = rep;
        proyectos = new ArrayList();
        elementos = new ArrayList();
        elementos.add(rep);
    }

    /**
     *
     * @param miembro un ciudadano que se quiere unir al colectivo
     * @return false si hay un error, true si el ciudadano ha sido registrado correctamente
     */
    public boolean unirseAColectivo(Ciudadano miembro){
        if (elementos.contains(miembro)){
            return false;
        }
        
        elementos.add(miembro);
        return true;
    }

    public boolean abandonarColectivo(Ciudadano miembro){
        if (elementos.contains(miembro)){
            elementos.remove(miembro);
            return true;
        }
        return false;
    }






    
}