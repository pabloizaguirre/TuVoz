import java.util.*;

/**
 * Clase Colectivo. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Colectivo extends ElementoColectivo {

    private String titulo;
    private Ciudadano representante;
    private ArrayList<ElementoColectivo> elementos;
    private ArrayList<Proyecto> proyectos;
    


    public Colectivo(String tit, Ciudadano rep){
        titulo = tit;
        representante = rep;
        proyectos = new ArrayList<Proyecto>();
        elementos = new ArrayList<ElementoColectivo>();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Ciudadano getRepresentante() {
        return this.representante;
    }

    public void setRepresentante(Ciudadano representante) {
        this.representante = representante;
    }

    public ArrayList<ElementoColectivo> getElementos() {
        return this.elementos;
    }

    public void setElementos(ArrayList<ElementoColectivo> elementos) {
        this.elementos = elementos;
    }

    public ArrayList<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    

    /**
     * Llamar a esta funcion cuando queramos unirnos a un colectivo
     *
     * @param miembro un ciudadano que se quiere unir al colectivo
     * @return false si hay un error, true si el ciudadano ha sido registrado correctamente
     */
    public boolean unirseAColectivo(Ciudadano miembro){
        if (elementos.contains(miembro)){
            return false;
        }
        elementos.add(miembro);
        
        miembro.anadirAMisColectivos(this);
        
        return true;
    }

    /**
     * Llamar a esta funcion cuando queramos abandunar un colectivo
     *
     * @param miembro un ciudadano que quiere abandoner el colectivo
     * @return false si el ciudadano no estaba en el colectivo, true si el ciudadano ha sido eliminado correctamente
     */
    public boolean abandonarColectivo(Ciudadano miembro){
        if (!elementos.contains(miembro)){
            return false;
        }
        elementos.remove(miembro);

        miembro.eliminarDeMisColectivos(this);
        
        return true;
    }




    
}