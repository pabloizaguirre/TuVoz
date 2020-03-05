import java.util.*;
/**
 * Clase usuario.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */


import java.util.*;


abstract class Usuario {
    private String nombreUsuario;
    private String contrasena

    private static ArrayList<String> listaNombres = new ArrayList();
 

    public void Usuario (String nombre, String contr){
        nombreUsuario= nombre;
        contrasena = contr;
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

    public ArrayList<String> getListaNombres() { return listaNombres; }

