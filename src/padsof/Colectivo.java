package padsof;
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
    private Colectivo superColectivo = null;




    public Colectivo(String tit, Ciudadano rep){
        titulo = tit;
        representante = rep;
        elementos = new ArrayList<ElementoColectivo>();
        unirseAColectivo(rep);
        Aplicacion.getAplicacion().anadirElementoColectivo(this);
    }

    /* Falta: igual habria que comprobar que el representante indicado es el mismo que el del colec
    tivo superior */
    public Colectivo(String tit, Colectivo colectivoSuperior){
        titulo = tit;
        representante = colectivoSuperior.getRepresentante();
        elementos = new ArrayList<ElementoColectivo>();
        colectivoSuperior.anadirSubcolectivo(this);
        superColectivo = colectivoSuperior;
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

    public List<proyectosApoyados> getProyectosapoyados() {
        return this.proyectosApoyados;
    }

    public void setElementos(ArrayList<ElementoColectivo> elementos) {
        this.elementos = elementos;
    }

    private Colectivo getSuperColectivo() {
        return this.superColectivo;
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
