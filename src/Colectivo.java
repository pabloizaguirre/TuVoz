package src;
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
    private List<ElementoColectivo> elementos;
    private List<Proyecto> proyectosApoyados;
    
    


    public Colectivo(String tit, Ciudadano rep){
        titulo = tit;
        representante = rep;
        elementos = new ArrayList<ElementoColectivo>();
        unirseAColectivo(rep);
        Aplicacion.getAplicacion().anadirElementoColectivo(this);
    }

    public Colectivo(String tit, Ciudadano rep, Colectivo colectivoSuperior){
        titulo = tit;
        representante = rep;
        elementos = new ArrayList<ElementoColectivo>();
        unirseAColectivo(rep);
        colectivoSuperior.anadirSubcolectivo(this);
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
        
    /**
     * Método para comprobar si un ciudadano o colectivo pertenece a un colectivo
     * 
     * @param u El ciudadano o colectivo que queremos comprobar
     * 
     * @return boolean. true si pertenece, false en caso contrario
     */
    public boolean esMiembro(ElementoColectivo u){
        if(elementos.contains(u)) return true;
        for(ElementoColectivo elem:elementos){
            if(elem.getClass().equals(Colectivo.class)){
                if(((Colectivo) elem).esMiembro(u)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Llamar a esta funcion cuando queramos unirnos a un colectivo
     *
     * @param miembro un ciudadano que se quiere unir al colectivo
     * @return false si hay un error, true si el ciudadano ha sido registrado correctamente
     */
    public boolean unirseAColectivo(Ciudadano miembro){
        if (esMiembro(miembro)){
            return false;
        }
        elementos.add(miembro);
        
        miembro.anadirAMisColectivos(this);

        //Apoyar los proyectos que apoya este colectivo
        for(Proyecto p: getProyectosApoyados()){
            p.apoyarProyecto(miembro);
        }
        
        return true;
    }

    /**
     * añade un subcolectivo a su lista de ElementosColectivo
     * @param c subcolectivo a añadir a este
     */
    public void anadirSubcolectivo(Colectivo c){
        /* Falta: manejar excepciones (el colectivo ya pertenece)*/
        elementos.add(c);
    }

    public void anadirAProyectosApoyados(Proyecto p){
        if(proyectosApoyados.contains(p)){
            return;
        }
        proyectosApoyados.add(p);
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


    /**
     * Método para buscar un colectivo en la aplicacion
     * 
     * @param str String con el nombre que deseamos buscar
     * 
     * @return Colectivo c que buscamos, null si no existe
     */
    public Colectivo bucarColectivo(String str){
        for (ElementoColectivo c:Aplicacion.getAplicacion().getListadoElementoColectivos()){
           if(c.getClass().equals(Colectivo.class))     
                if(((Colectivo)c).getTitulo().equals(str)){
                    return (Colectivo)c;
                    }
            }
        return null;
    }
    
}