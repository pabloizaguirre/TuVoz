import java.util.*;

/**
 * Clase aplicacion.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Aplicacion {

    private int apoyosMin;
    

    public Aplicacion(int votosMin){
        apoyosMin = votosMin;
    }

    public int getApoyosMin() { return apoyosMin;}
    public void setApoyosMin(int apoyosMin) {this.apoyosMin = apoyosMin;}

    public static void main(){
        //La aplicacion debe tener en cuenta los usuarios creados y llamar al constructor de usuario si el nombre esta disponible
        String user1Name = "ElenitaCanocas";
        String nif1 = "69696969";
        Ciudadano user1;
        //Creamos el primer usuario
        if(!Usuario.nombreEnUso(user1Name) && !Ciudadano.nifEnUso(nif1)){
            user1 = new Ciudadano("AmoAlCoquito", user1Name, nif1, true);
        } else {
            System.out.println("El nombre " + user1Name + " o el nif " + nif1 + " está en uso\n");
        }

        String user2Name = "MiguelElFeo";
        String nif2 = "420420420";
        Ciudadano user2;
        //Creamos el segundo usuario
        if(!Usuario.nombreEnUso(user2Name) && !Ciudadano.nifEnUso(nif2)){
            user2 = new Ciudadano("AmoAlBrazos", user2Name, nif2, true);
        } else {
            System.out.println("El nombre " + user2Name + " o el nif " + nif2 + " está en uso\n");
        }

        //Creamos un administrador
        String AdminName = "PabloElChulo";
        if(!Usuario.nombreEnUso(AdminName)){
            Usuario admin = new Administrador(AdminName, "AmorDeMadre<3");
        } else {
            System.out.println("El nombre " + AdminName + " ya está en uso\n");
        }

        //Ahora tenemos que comprobar los métodos para aprobar los registros
        System.out.println("Aprobamos el registro de user1");
        user1.aprobarRegistro();

        System.out.println("Aprobamos el registro de user2");
        user2.aprobarRegistro();
        

        //Creamos un colectivo
        System.out.println("Creamos un nuevo colectivo con " + user1 + "como representante\n");
        Colectivo marujeo = new Colectivo("Marujeo del bueno", user1);

        //Comprobamos distintas funciones de colectivo

        //Unirse a colectivo
        if(!marujeo.unirseAColectivo(user2)){
            System.out.println("El ciudadano " + user2 + " no se ha podido unir  al colectivo " + marujeo + "\n");
        } else {
            System.out.println("El usuario se ha unido correctamente al colectivo\n");
        }
        //Comprobamos si el representante y user2 pertenecen al colectivo
        if(!marujeo.esMiembro(user1)){
            System.out.println("Error, el representante no es miembro del colectivo\n");
        }
        if(!marujeo.esMiembro(user2)){
            System.out.println("Error, el usuario no se ha unido al colectivo correctamente\n");
        }


        //Creamos un proyecto 

        //Comprobamos distintas funciones de proyecto

        //Comprobar que un usuario bloqueado no puede apoyar proyectos

        //Comprobar que cuando un usuario ha sido bloqueado, sus apoyos a proyectos son retirados
    }


}

