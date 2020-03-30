package padsof;
import java.util.*;
import java.io.*;


/**
 * Clase Ciudadano.
 *
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Ciudadano extends Usuario implements ElementoColectivo, Serializable{


    private String nif;
    private boolean bloqueado;
    private boolean registrado;

    //lista de colectivos de los que soy miembro
    private List<Colectivo> misColectivos = new ArrayList<Colectivo>();
    //lista de colectivos de los que es representante
    private List<Colectivo> colectivosCreados = new ArrayList<Colectivo>();
    private List<Proyecto> proyectosSuscritos = new ArrayList<Proyecto>();
    private List<Proyecto> proyectosPropuestos = new ArrayList<Proyecto>();
    private List<Proyecto> proyectosApoyados = new ArrayList<Proyecto>();


    public Ciudadano(String contr, String nomUs, String nif){
        super(nomUs, contr);
        this.nif = nif;
        this.bloqueado = false;
        this.registrado = false;
        Aplicacion.getAplicacion().anadirElementoColectivo(this);
        new Notificacion("Aprobación de registro pendiente: " +nomUs, Aplicacion.getAplicacion().getAdministrador());
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean isRegistrado() {
        return this.registrado;
    }

    public List<Colectivo> getMisColectivos() {
        return this.misColectivos;
    }

    public void setMisColectivos(ArrayList<Colectivo> misColectivos) {
        this.misColectivos = misColectivos;
    }

    public List<Colectivo> getColectivosCreados() {
        return this.colectivosCreados;
    }

    public void setColectivosCreados(ArrayList<Colectivo> colectivosCreados) {
        this.colectivosCreados = colectivosCreados;
    }

    public List<Proyecto> getProyectosSuscritos() {
        return this.proyectosSuscritos;
    }

    public void setProyectosSuscritos(ArrayList<Proyecto> proyectosSuscritos) {
        this.proyectosSuscritos = proyectosSuscritos;
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
     * Método para comprobar si un NIF pertenece a un ciudadano existente en la aplicacion
     *
     * @param str String con el NIF a comprobar
     * @return boolean, true si el NIF está usado, false en caso contrario
     */

    public static boolean nifEnUso(String str) {
        for(ElementoColectivo c :Aplicacion.getAplicacion().getListadoElementoColectivos())
            if(c.getClass().equals(Ciudadano.class))
                if(((Ciudadano)c).getNif().equals(str)){
                    return true;
                }
        return false;
    }

    /**
     * Método para registrar a un nuevo ciudadano en la aplicación, controlando que
     * el nombre de usuario y el NIF introducidos no estén ya en uso
     *
     * @param contr String con la contraseña del usuario
     * @param nomUs String con el nombre de usuario
     * @param nif String con el NIF del usuario
     *
     * @return boolean, true si el NIF está usado, false en caso contrario
     */

    public static Ciudadano registrarCiudadano(String contr, String nomUs, String nif) {
        if(nifEnUso(nif) || Usuario.nombreEnUso(nomUs)){
            return null;
        }

        return new Ciudadano(contr,nomUs,nif);
    }

    /**
     * Método para aprobar un registro de un usuario por parte del administrador
     *
     * @return void
     */
    public void aprobarRegistro(){
        this.registrado=true;
        Aplicacion.getAplicacion().anadirElementoColectivo(this);

    }


     /**
     * Método para bloquear a un usuario por parte del administrador
     *
     * @return void
     */

    public void bloquearCiudadano() {
        this.bloqueado = true;
        for(Proyecto p:proyectosApoyados){
            p.eliminarApoyo(this);
        }
        proyectosApoyados.clear();
        return;
    }

     /**
     * Método para desbloquear a un usuario por parte del administrador
     *
	 *
	 * @return void
     */
    public void desbloquearCiudadano() {
        this.bloqueado = false;
    }


    /**
     * Método para buscar un ciudadano a través de un String
     *
     * @param Ciudadano ing con el nombre de usuario
	 *
	 * @return El ciudadano si existe, null en caso contrario
     */
    public static Ciudadano buscarCiudadano(String str) {
        for(ElementoColectivo c :Aplicacion.getAplicacion().getListadoElementoColectivos()) {
            if(c.getClass().equals(Ciudadano.class))
                if(((Ciudadano)c).getNombreUsuario().equals(str)) {
                    return (Ciudadano)c;
                }
        }
        return null;
    }



    /**
     * Método para añadir un colectivo a tu lista
     *
     * @param c colectivo que se quiere añadir
     *
     * @return true en caso favorable, false si ya estuviera añadido a sus colectivos
     */
    public boolean anadirAMisColectivos(Colectivo c){
        if(misColectivos.contains(c)){
            return false;
        }
        misColectivos.add(c);

        return true;
    }



    /**
     * Método para eliminar un colectivo de tu lista
     *
     * @param c colectivo que se quiere eliminar
     *
     * @return true en caso favorable, false si no estuviera añadido a sus colectivos
     */
    public boolean eliminarDeMisColectivos(Colectivo c){
        if(!misColectivos.contains(c)){
            return false;
        }
        misColectivos.remove(c);

        return true;
    }


    /**
     * Método para añadir un proyecto a la ista de suscritos
     *
     * @param p proyecto que se quiere añadir
     *
     * @return true en caso favorable, false si ya estuviera añadido
     */
     public boolean anadirAMisProyectosSuscritos(Proyecto p){
        if(proyectosSuscritos.contains(p)){
            return false;
        }
        proyectosSuscritos.add(p);

        return true;
    }


    /**
     * Método para solicitar el informe de popularidad
     *
     * @param p proyecto creado por el usuario del cual se quiere solicitar el informe
     * @return numero de apoyos que tiene el proyecto p
     */
    public void solicitarInformePopularidad(Proyecto p){
        String s;
        if (getProyectosPropuestos().contains(p)){
            s = "Informe de popularidad del proyecto " + p + " :\nNúmero de apoyos = " + p.getApoyos();

            new Notificacion(s, this);
        }
    }

    /**
     * Método para solicitar el informe de afinidad
     *
     * @param c1 Primer colectivo del cual se quiere solicitar este informe.
     * @param c2 Segundo colectivo del cual se quiere solicitar este informe.
     * El usuario debe pertenecer a ambos colectivos.
     *
     * @return double que representa el indice de afinidad entre dos colectivos.
     */
    public void solicitarInformeAfinidad(Colectivo c1, Colectivo c2){
        int proyeC1=0;
        int proyeC2=0;
        int proyeC1apoyC2=0;
        int proyeC2apoyC1=0;
        String s;

        if (misColectivos.contains(c1) && misColectivos.contains(c2)){
            for (Proyecto p:c1.getProyectosPropuestos()){
                proyeC1+=1;
                if(p.getListadoApoyos().contains(c2)){
                    proyeC1apoyC2+=1;
                }
            }
            for (Proyecto p:c2.getProyectosPropuestos()){
                proyeC2+=1;

                if(p.getListadoApoyos().contains(c2)){
                    proyeC2apoyC1+=1;
                }
            }
            s = "Informe de afinidad de los colectivos " + c1 + " y " + c2 + " :\nÍndice de afinidad: " + (proyeC1apoyC2 + proyeC2apoyC1)/(proyeC1 + proyeC2);
            new Notificacion(s, this);
        }
    }


    public String toString(){
        return getNombreUsuario() + ", nif: " + nif;
    }

}



