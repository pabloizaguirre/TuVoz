package padsof;
import java.util.*;
/**
 * Clase usuario.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

abstract class Usuario{
    private String nombreUsuario;
    private String contrasena;

    private static ArrayList<String> listaNombres = new ArrayList<String>();
    //lista de notificaciones recibidas por este usuario
    private List<Notificacion> notificaciones;
    
    public Usuario (String nombre, String contr){
        nombreUsuario = nombre;
        contrasena = contr;
        notificaciones = new ArrayList<Notificacion>();
        listaNombres.add(nombre);
    }

    public String getNombreUsuario (){
        return nombreUsuario;
    }
    

    public boolean setNombreUsuario (String nombre){
        if (listaNombres.contains(nombre)){
            return false;
        }
        else{
            nombreUsuario=nombre;
            listaNombres.add(nombre);
            return true;
        }
        
    }

    public ArrayList<String> getListaNombres() { 
        return listaNombres; 
    }


    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Notificacion> getNotificaciones() {
        return this.notificaciones;
    }



    /**
     * Esta funcion comprueba si un nombre de usuario está usado en la aplicación
     * @param str String con el nombre de usuario
     * @return true si está usado, false en caso contrario
     */
    public static boolean nombreEnUso(String str) {
        if(listaNombres.contains(str)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Esta funcion añade una notificacion a la lista de notificaciones del usuario
     * @param n notificacion a añadir
     * @return true si ha sido añadida con exito, false en caso contrario
     */
    public boolean anadirNotificacion(Notificacion n){
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
    public boolean eliminarNotificacion(Notificacion n){
        if(notificaciones.contains(n)){
            notificaciones.remove(n);
            return true;
        } else {
            return false;
        }
    }
    

}



