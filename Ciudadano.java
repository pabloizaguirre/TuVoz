import java.util.*;

/**
 * Clase Ciudadano. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Ciudadano extends Usuario {


    private String nif;
    private boolean bloqueado;
    private boolean registrado;

    //lista de colectivos de los que soy miembro
    private List<Colectivo> misColectivos = new ArrayList<Colectivo>();
    //lista de colectivos de los que es representante
    private List<Colectivo> colectivosCreados;
    private List<Proyecto> proyectosApoyados;
    private List<Proyecto> proyectosSuscritos;
    //lista de notificaciones recibidas por este usuario
    private List<Notificacion> notificaciones = new ArrayList<Notificacion>();
    


    public Ciudadano(String contr, String nomUs, String nif, boolean bloq){
        super(nomUs, contr);
        this.nif = nif;
        this.bloqueado = bloq;
        this.registrado=false;
        Aplicacion.getAplicacion().anadirElementoColectivo(this);
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

    public List<Proyecto> getProyectosApoyados() {
        return this.proyectosApoyados;
    }

    public void setProyectosApoyados(ArrayList<Proyecto> proyectosApoyados) {
        this.proyectosApoyados = proyectosApoyados;
    }

    public List<Proyecto> getProyectosSuscritos() {
        return this.proyectosSuscritos;
    }

    public void setProyectosSuscritos(ArrayList<Proyecto> proyectosSuscritos) {
        this.proyectosSuscritos = proyectosSuscritos;
    }

    public List<Notificacion> getNotificaciones() {
        return this.notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    
    public static boolean nifEnUso(String str) {
        for(Ciudadano c :todosLosCiudadanos) {
            if(c.getNif().contains(str)){
                return true;
            }
        }
        return false;
    }

    public boolean nombreUsuarioEnUso(String str) {
        for(Ciudadano c :todosLosCiudadanos) {
            if(c.getNombreUsuario().contains(str)) {
                return true;
            }
        }
        return false;
    }

    public Ciudadano registrarUsuario(String contr, String nomUs, String nif) {
        if(nifEnUso(nif) || nombreUsuarioEnUso(nomUs)){
            return null;
        }
        return new Ciudadano(contr,nomUs,nif, false);
    }

    public void aprobarRegistro(){
        this.registrado=true;
    }


     /**
     * Método para bloquear a un usuario por parte del administrador
     * 
     * @return void
     */

    public void bloquearUsuario() {
        /* Falta: comprobar esto */
        if(Aplicacion.usuarioActual.equals(Administrador.class)) {
            this.bloqueado = true;
            for(Proyecto p : this.proyectosApoyados) {
                p.eliminarApoyo(this);
                proyectosApoyados.remove(p);
            }
        }
        return;
    }

     /**
     * Método para desbloquear a un usuario
     * 
	 * 
	 * @return void
     */
    public void desbloquearUsuario() {
        if(Aplicacion.usuarioActual.equals(Administrador.class )) {
            this.bloqueado = false;
        }
    }

    /**
     * Método para buscar un ciudadano a través de un String
     * 
     * @param str String con el nombre de usuario
	 * 
	 * @return El ciudadano si existe, null en caso contrario
     */

    public Ciudadano buscarCiudadano(String str){
        for (Ciudadano c:todosLosCiudadanos){
            if(c.getNombreUsuario().equals(str)){
                return c;
            }
        }
        return null;
    }

    /**
     * Esta funcion añade una notificacion al conjunto de notificaciones de este usuario
     * @param n notificacion a añadir
     * @return false si el usuario ya tenia la notificacion, true si se ha añadido con exito
     */
    public boolean addNotificacion(Notificacion n){
        if(notificaciones.contains(n)){
            return false;
        } else {
            notificaciones.add(n);
            return true;
        }
    }
    
    /**
     * Esta funcion elimina una notificacion de la lista de notificaciones del usuario
     * @param n notificacion a borrar
     * @return false si la notificacion ya ha sido borrara o true si la eliminacion se ha realizado con exito
     */
    public boolean removeNotificacion(Notificacion n){
        if(notificaciones.contains(n)){
            notificaciones.remove(n);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Esta funcion solo debe ser llamada por unirseAColectivo,
     * no deberiamos llamar a esta funcion cuando queramos unirnos a un colectivo
     *s
     * @param c un ciudadano que se quiere unir al colectivo
     * @return false si el ciudadano ya es miembro de ese colectivo, true si el ciudadano ha sido añadido correctamente 
     * a la lista de misColectivos.
     */
    public boolean anadirAMisColectivos(Colectivo c){
        if(misColectivos.contains(c)){
            return false;
        }
        misColectivos.add(c);
        
        return true;
    }
    
    public boolean eliminarDeMisColectivos(Colectivo c){
        if(!misColectivos.contains(c)){
            return false;
        }
        misColectivos.remove(c);
        
        return true;
    }


    public boolean anadirAMisProyectosApoyados(Proyecto p){
        if(proyectosApoyados.contains(p)){
            return false;
        }
        proyectosApoyados.add(p);
        
        return true;
    }
    
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
    public int solicitarInformePopularidad(Proyecto p){
        if (getProyectosPropuestos().contains(p)){
            return p.getApoyos();
        }

        else{return -1;}
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
    public double solicitarInformeAfinidad(Colectivo c1, Colectivo c2){
        int proyeC1=0;
        int proyeC2=0;
        int proyeC1apoyC2=0;
        int proyeC2apoyC1=0;

        if (misColectivos.contains(c1) && misColectivos.contains(c2)){
            for (Proyecto p:c1.getProyectosPropuestos()){
                proyeC1+=1;
                /* Falta: esto esta bien en el caso de que si un colectivo apoya un proyecto
                no cuenta como que sus subcolectivos tb lo apoyan */
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
            return (proyeC1apoyC2 + proyeC2apoyC1)/(proyeC1 + proyeC2) ;
        }
        else return -1;
    }

    

}
  