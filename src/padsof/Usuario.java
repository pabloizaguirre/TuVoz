package src;
import java.util.*;
/**
 * Clase usuario.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

abstract class Usuario extends ElementoColectivo{
    private String nombreUsuario;
    private String contrasena;

    private static ArrayList<String> listaNombres = new ArrayList<String>();
    
    public Usuario (String nombre, String contr){
        nombreUsuario = nombre;
        contrasena = contr;
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

    public static boolean nombreEnUso(String str) {
        if(listaNombres.contains(str)) {
            return true;
        }
        else {
            return false;
        }
    }
    

}



