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
    private static Usuario usuarioActual;
    

    public Aplicacion(int apoyosMin, Usuario usuarioActual){
        this.apoyosMin = apoyosMin;
        this.usuarioActual = usuarioActual;
    }

    /* Falta: yo quitaria esto */
    public int getApoyosMin() { return apoyosMin;}
    public void setApoyosMin(int apoyosMin) {this.apoyosMin = apoyosMin;}

    public static Ciudadano registrarCiudadano(String nombre, String nif, String contraseña) {
        if (!Usuario.nombreEnUso(nombre) && !Ciudadano.nifEnUso(nif)) {
            return new Ciudadano(contraseña, nombre, nif, true);
        } else {
            return null;
        }
    }

    public static Administrador registrarAdministrador(String nombre, String contraseña){
        if(!Usuario.nombreEnUso(nombre)){
            return new Administrador(nombre, contraseña);
        } else {
            return null;
        }
    }

    public static void main() {
        // La aplicacion debe tener en cuenta los usuarios creados y llamar al
        // constructor de usuario si el nombre esta disponible
        Ciudadano[] users = new Ciudadano[3];
        // Creamos el primer usuario
        if ((users[0] = registrarCiudadano("ElenitaCanocas", "123alesconditeingles", "AmoAlCoquito")) == null) {
            System.out.println("El nombre ElenitaCanocas o el nif 123alesconditeingles esta en uso\n");
        }
        if ((users[1] = registrarCiudadano("MiguelElFeo", "420420420", "AmoAlBrazos")) == null) {
            System.out.println("El nombre MiguelElFeo o el nif 420420420 está en uso\n");
        }
        if ((users[2] = registrarCiudadano("Minion", "142131131", "c0ntrasena")) == null) {
            System.out.println("El nombre Minion o el nif 142131131 está en uso\n");
        }
        if ((users[3] = registrarCiudadano("NoRegistrado", "333222", "c0ntrasena")) == null) {
            System.out.println("El nombre NoRegistrado o el nif 333222 está en uso\n");
        }

        //Creamos un administrador
        Administrador admin;
        if((admin = registrarAdministrador("PabloElChulo", "AmorDeMadre<3")) == null){
            System.out.println("El nombre PabloElChulo ya está en uso\n");
        }

        //Comprobar que no se puede crear un nuevo usuario con un nombre usado
        System.out.println("Comprobamos si intentamos crear un usuario con un nombre ya usado la funcion registrar() devuelve null: " + (registrarCiudadano("ElenitaCanocas", "123123123", "VivaSamanthaHudson") == null));



        //Ahora tenemos que comprobar los métodos para aprobar los registros
        System.out.println("Aprobamos el registro de users[0]");
        users[0].aprobarRegistro();

        System.out.println("Aprobamos el registro de users[1]");
        users[1].aprobarRegistro();

        System.out.println("Aprobamos el registro de users[2]");
        users[2].aprobarRegistro();

        //No hemos aprobado el registro de users[3]
        

        //Creamos un colectivo
        System.out.println("Creamos un nuevo colectivo con " + users[0] + "como representante\n");
        Colectivo marujeo = new Colectivo("Marujeo del bueno", users[0]);

        //Comprobamos distintas funciones de colectivo

        //Unirse a colectivo
        if(!marujeo.unirseAColectivo(users[1])){
            System.out.println("El ciudadano " + users[1] + " no se ha podido unir  al colectivo " + marujeo + "\n");
        } else {
            System.out.println("El usuario se ha unido correctamente al colectivo\n");
        }
        //Comprobamos si el representante y users[1] pertenecen al colectivo
        if(!marujeo.esMiembro(users[0])){
            System.out.println("Error, el representante no es miembro del colectivo\n");
        }
        if(!marujeo.esMiembro(users[1])){
            System.out.println("Error, el usuario no se ha unido al colectivo correctamente\n");
        }


        //Creamos dos proyectos
        //Primero de forma individual por users[1]
        /* ProyectoInfraestructura p1 = new ProyectoInfraestructura( Aqui faltan los argumentos );

        //Comprobamos quien lo ha apoyado. Deberia ser solamente el users[1]
        System.out.println("\nComprobamos el listado de apoyos del proyecto. El unico apoyo debería ser del creador del proyecto\n");
        System.out.println("Listado de apoyos al proyecto " + p1);
        for (ElementoColectivo elem:p1.getListadoApoyos()){
            System.out.println(elem);
        }

        //Un colectivo apoya el proyecto 
        System.out.println("El colectivo " + marujeo + " apoya el proyecto " + p1);
        p1.apoyarProyecto(marujeo);
        //El numero de apoyos debería ser 2 ya que users[1] ya apoyaba el proyecto
        System.out.println("Numero de apoyos de " + p1);
        System.out.println("Numero de apoyos: " + p1.getApoyos() + "\n");
       

        System.out.println("Listado de apoyos al proyecto " + p1);
        for (ElementoColectivo elem:p1.getListadoApoyos()){
            System.out.println(elem);
        }

        //Comprobamos si user[3] (cuyo registro no ha sido aprobado) puede apoyar el proyecto
        System.out.println("Comprobamos si user[3] (cuyo registro no ha sido aprobado) puede apoyar el proyecto\n");
        p1.apoyarProyecto(users[3]);
        System.out.println("Numero de apoyos: " + p1.getApoyos() + "\n");
        System.out.println("Listado de apoyos al proyecto " + p1);
        for (ElementoColectivo elem:p1.getListadoApoyos()){
            System.out.println(elem);
        } */

        //Bloquear usuario

        //Comprobar que un usuario bloqueado no puede apoyar proyectos

        //Comprobar que cuando un usuario ha sido bloqueado, sus apoyos a proyectos son retirados
    }


}

