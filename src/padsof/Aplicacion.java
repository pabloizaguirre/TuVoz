package padsof;
import java.util.*;
import java.io.*;

/**
 * Clase aplicacion.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Aplicacion implements Serializable {

    private static Aplicacion aplicacion;
    
    private int apoyosMin;
    private List<Proyecto> listadoProyectos;
    private List<ElementoColectivo> listadoElementoColectivos;
    private Administrador administrador;
    private Usuario usuarioActual;

    private Aplicacion(){
        this.listadoProyectos = new ArrayList<Proyecto>();
        this.listadoElementoColectivos = new ArrayList<ElementoColectivo>();
    }

    public static Aplicacion getAplicacion() {
        if(aplicacion == null) {
            aplicacion = new Aplicacion();
        }
        return aplicacion;
    }

    public int getApoyosMin() { return apoyosMin;}
    public void setApoyosMin(int apoyosMin) {this.apoyosMin = apoyosMin;}


    public List<Proyecto> getListadoProyectos() {
        return this.listadoProyectos;
    }

    public void setListadoProyectos(List<Proyecto> listadoProyectos) {
        this.listadoProyectos = listadoProyectos;
    }

    public List<ElementoColectivo> getListadoElementoColectivos() {
        return this.listadoElementoColectivos;
    }

    public void setListadoElementoColectivos(List<ElementoColectivo> listadoElementoColectivos) {
        this.listadoElementoColectivos = listadoElementoColectivos;
    }

    public Usuario getUsuarioActual(){
        return this.usuarioActual;
    }


    public Administrador getAdministrador() {
        return this.administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Metodo para registrar un administrador
     * 
     * @param nombre String con el nombre del administrador
     * @param contraseña String con la contraseña del administrador
     * 
     * @return Objeto de clase Administrador en caso favorable, null si se ha producido un error
     */
    public static Administrador registrarAdministrador(String nombre, String contrasena){
        if(getAplicacion().getAdministrador()==null){
            if(!Usuario.nombreEnUso(nombre)){
                Administrador admin = new Administrador(nombre, contrasena);
                getAplicacion().setAdministrador(admin);
                return admin;
            }
            return null;
        }
        return getAplicacion().getAdministrador();
    }

    /**
     * Metodo para guardar la informacion de la aplicacion en un fichero
     * 
     * 
     * @return void
     */
    public void guardarAplicacion() {
		ObjectOutputStream salida = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("TuVoz.dat");
			salida = new ObjectOutputStream(fos);
			salida.writeObject(this);
		} catch (IOException ex) {
			System.out.println("Fallo al guardar en el archivo");
 
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo al guardar en el archivo");
			}
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo al guardar en el archivo");
			}
		}
	}

     /**
     * Metodo para cargar los datos a la aplicación desde un fichero dado
     * 
     * @param ruta String con la ruta del archivo
     * 
     * @return Objeto de clase Aplicacion
     */
    public Aplicacion cargarAplicacion(String ruta) {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Aplicacion obj = null;
		try {
			fis = new FileInputStream(ruta);
			entrada = new ObjectInputStream(fis);
			obj = (Aplicacion) entrada.readObject();
		} catch (IOException ex) {
			System.out.println("Fallo al cargar desde el archivo");
		} catch (ClassNotFoundException ex) {
			System.out.println("Fallo al cargar desde el archivo");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo al cargar desde el archivo");
			}
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo al cargar desde el archivo");
			}
		}
		return obj;
    }
    
     /**
     * Metodo para añadir un proyecto a la lista de proyectos
     * 
     * @param p Proyecto a añadir a la lista
     *      
     * @return void
     */

    public void anadirProyecto(Proyecto p) {
        if(listadoProyectos.contains(p)) {
            return;
        }
        listadoProyectos.add(p);
        return;
    }

    /**
     * Metodo para eliminar un proyecto de la lista de proyectos
     * 
     * @param p Proyecto a eliminar de la lista
     *      
     * @return void
     */
    public void eliminarProyecto(Proyecto p) {
        if(listadoProyectos.contains(p)){
            listadoProyectos.remove(p);
        }
        return;
    }

    /**
     * Metodo para añadir un objeto ElementoColectivo a la lista de ElementoColectivo
     * 
     * @param e ElementoColectivo a añadir a la lista
     *      
     * @return void
     */
    public void anadirElementoColectivo(ElementoColectivo e) {
        if(listadoElementoColectivos.contains(e)) {
            return;
        }
        listadoElementoColectivos.add(e);
        return;
    }

 

    public static void main(String[] args) {
        Administrador admin;
        if((admin = registrarAdministrador("PabloElChulo", "AmorDeMadre<3")) == null){
            System.out.println("El nombre PabloElChulo ya está en uso\n");
        }

        Ciudadano u1 = Ciudadano.registrarCiudadano("AmoAlCoquito", "ElenitaCanocas", "12312312F");
        if(u1==null){
            System.out.println("Se ha procudido un error al registrar a ElenitaCanocas\n");

        }
        Ciudadano u2 = Ciudadano.registrarCiudadano("AmoAlBrazos", "MiguelCaraPan", "12343212A");
        if(u2==null){
            System.out.println("Se ha procudido un error al registrar a MiguelCaraPan\n");

        }

        u1.aprobarRegistro();
        u2.aprobarRegistro();

        System.out.println("Creamos un nuevo colectivo con " + u1 + " como representante\n");
        Colectivo c1 = new Colectivo("Deporte", u1);

        System.out.println("Creamos un subcolectivo de " + c1 + "\n");
        Colectivo c2 = new Colectivo("Natacion", c1);

        //Comprobamos que en c1 está el representate y el subcolectivo

        System.out.println("Elementos del colectivo " + c1 + ":");
        for(ElementoColectivo elem: c1.getElementos()){
            System.out.println(">>" + elem);
        }

        //Creamos un proyecto como colectivo
        List<Distrito> d = new ArrayList<Distrito>();
        d.add(Distrito.moncloaAravaca);
        ProyectoInfraestructura p1 = new ProyectoInfraestructura("Puente", "Puente por encima del rio", 2121234, c1, new Imagen("PlanoPuente.jpg"), d);
        System.out.println("\nEl colectivo " + c1 + " ha creado el proyecto " + p1);
        
        //Comprobamos que el proyecto tiene un apoyo, el del representante
        System.out.println("El proyecto " + p1 + " tiene " + p1.getApoyos() + " apoyos\n");

        //Añadimos u2 al subcolectivo c2 y comprobamos si aumenta el numero de apoyos
        System.out.println("Se une " + u2 + " al colectivo " + c2);
        p1.apoyarProyecto(u2);

        System.out.println("El proyecto " + p1 + " tiene " + p1.getApoyos() + " apoyos\n");

        //Aprobar proyecto
        p1.cambiarEstado(EstadoProyecto.noEnviado); 

        //Comprobar las notificaciones que ha recibido u1
        System.out.println(u1 + " ha recibido las siguientes notificaciones:");
        for(Notificacion n: u1.getNotificaciones()){
            System.out.println(">>" + n.getTextoNotificacion());
        }

        //Comprobar las notificaciones que ha recibido admin
        System.out.println(admin + " ha recibido las siguientes notificaciones:");
        for(Notificacion n: admin.getNotificaciones()){
            System.out.println(">>" + n.getTextoNotificacion());
        }

        //Enviar a financiacion
    }


}

