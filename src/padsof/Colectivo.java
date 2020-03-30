package padsof;
import java.util.*;
import java.io.*;


/**
 * Clase Colectivo.
 *
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Colectivo implements ElementoColectivo, Serializable {


    private String titulo;
    private Ciudadano representante;
    private List<ElementoColectivo> elementos = new ArrayList<ElementoColectivo>();
    private Colectivo superColectivo = null;
    private List<Proyecto> proyectosPropuestos = new ArrayList<Proyecto>();
    private List<Proyecto> proyectosApoyados = new ArrayList<Proyecto>();




    public Colectivo(String tit, Ciudadano rep){
        titulo = tit;
        representante = rep;
        unirseAColectivo(rep);
        Aplicacion.getAplicacion().anadirElementoColectivo(this);
    }

    /* Falta: igual habria que comprobar que el representante indicado es el mismo que el del colec
    tivo superior */
    public Colectivo(String tit, Colectivo colectivoSuperior){
        titulo = tit;
        representante = colectivoSuperior.getRepresentante();
        colectivoSuperior.anadirSubcolectivo(this);
        superColectivo = colectivoSuperior;
        Aplicacion.getAplicacion().anadirElementoColectivo(this);
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

    private Colectivo getSuperColectivo() {
        return this.superColectivo;
    }

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


    /**
     * Metodo para eliminar un proyecto de la lista de proyectos apoyados
     * 
     * @param p Proyecto que deseamos eliminar de la lista
     */
    public void eliminarDeMisProyectosApoyados(Proyecto p){
        if(proyectosApoyados.contains(p)){
            proyectosApoyados.remove(p);
            return;
        }
        return;
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
     * Metodo para encontrar el maximo colectivo que abarca a este, su colectivo raiz
     *
     * @return maximo superColectivo
     */
    private Colectivo ColectivoRaiz(){
        Colectivo c = superColectivo;

        while(c!=null){
            return c.ColectivoRaiz();
        }
        return this;
    }

    /**
     * Llamar a esta funcion cuando queramos unirnos a un colectivo
     *
     * @param miembro un ciudadano que se quiere unir al colectivo
     * @return false si hay un error, true si el ciudadano ha sido registrado correctamente
     */
    public boolean unirseAColectivo(Ciudadano miembro){
        if(ColectivoRaiz().esMiembro(miembro)){
            return false;
        }
        elementos.add(miembro);

        miembro.anadirAMisColectivos(this);

        //Apoyar los proyectos que apoya este colectivo y sus superiores
        Colectivo c = this;
        while(c!=null){
            for(Proyecto p: getProyectosApoyados()){
                p.apoyarProyecto(miembro);
            }
            c = c.getSuperColectivo();
        }

        return true;
    }

    /**
     * añade un subcolectivo a su lista de ElementosColectivo
     *
     * @param c subcolectivo a añadir a este
     */
    public void anadirSubcolectivo(Colectivo c){
        if(elementos.contains((ElementoColectivo)c)) {
            return;
        }
        elementos.add(c);
        return;
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
    public static Colectivo buscarColectivo(String str){
        for (ElementoColectivo c:Aplicacion.getAplicacion().getListadoElementoColectivos()){
           if(c.getClass().equals(Colectivo.class)){
                if((((Colectivo)c).getTitulo()).compareTo(str)==0){
                    return (Colectivo)c;
                }
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return titulo;
    }

}
