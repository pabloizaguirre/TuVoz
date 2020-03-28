import java.util.*;

/**
 * Clase Colectivo. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Colectivo extends ElementoColectivo {

    private static List<Colectivo> todosLosColectivos = new ArrayList<Colectivo>();

    private String titulo;
    private Ciudadano representante;
    private List<ElementoColectivo> elementos;
    private List<Proyecto> proyectos;
    


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

    public List<ElementoColectivo> getElementos() {
        return this.elementos;
    }

    public void setElementos(ArrayList<ElementoColectivo> elementos) {
        this.elementos = elementos;
    }

    public List<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }


    /* Falta: que compruebe dentro de los colectivos si el usuario es miembro de los subcolectivos */
    public boolean esMiembro(Ciudadano u){
        if(elementos.contains(u)) return true;
        else return false;

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

    /* public Colectivo buscarColectivo(String str) {
        if(todosLosColectivos.get().contains(str)) {
            return todosLosColectivos.get().contains(str);
        }
        return null;
    } */

    public Colectivo bucarColectivo(String str){
        for (Colectivo c:todosLosColectivos){
            if(c.getTitulo().equals(str)){
                return c;
            }
        }
        return null;
    }
    
}