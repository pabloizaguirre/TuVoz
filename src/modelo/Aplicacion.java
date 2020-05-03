package modelo;
import es.uam.eps.sadp.grants.*;

import java.util.*;
import java.io.*;
import java.io.IOException;

/**
 * Clase aplicacion.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Aplicacion implements Serializable {

    private static Aplicacion aplicacion;
    
    private ArrayList<String> listaNombres = new ArrayList<String>();
    private int apoyosMin;
    private int ultimoIdAsignado;
    private List<Proyecto> listadoProyectos;
    private List<ElementoColectivo> listadoElementoColectivos;
    private Administrador administrador;
    private Usuario usuarioActual;
    

    public Aplicacion(){
        this.listadoProyectos = new ArrayList<Proyecto>();
        this.listadoElementoColectivos = new ArrayList<ElementoColectivo>();
        this.administrador = new Administrador("Admin", "123");
        this.apoyosMin = 10;
        this.ultimoIdAsignado = 0;
    }

    public static Aplicacion getAplicacion() {
        if(aplicacion == null) {
            aplicacion = new Aplicacion();
        }
        return aplicacion;
    }
    
    public ArrayList<String> getListaNombres(){
    	return listaNombres;
    }
    
    public void setListaNombres(ArrayList<String> l) {
    	this.listaNombres = l;
    }
    
    public int getUltimoIdAsignado() {
    	return this.ultimoIdAsignado;
    }
    
    public void setUltimoIdAsignado(int id) {
    	this.ultimoIdAsignado = id;
    }

    public int getApoyosMin() { return apoyosMin;}

    public void setApoyosMin(int apoyosMin) {
        this.apoyosMin = apoyosMin;
        for (Proyecto p : listadoProyectos) {
            p.consultarEstadoProyecto();
        }
        
    }


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
    
    public void setUsuarioActual(Usuario usuarioActual) {
    	this.usuarioActual = usuarioActual;
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
     * @param contrasena String con la contraseña del administrador
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
     * @param aplicacion Aplicacion
     */
    public static void guardarAplicacion() {
		ObjectOutputStream salida = null;
		FileOutputStream fos = null;
		try {
			aplicacion.setListaNombres(Usuario.getListaNombres());
			fos = new FileOutputStream("data.dat");
			salida = new ObjectOutputStream(fos);
            salida.writeObject(Aplicacion.getAplicacion());
            
            salida.close();
            fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
 
		} 
		
	}

     /**
     * Metodo para cargar los datos a la aplicación desde un fichero dado
     * 
     *
     * 
     * @return Objeto de clase Aplicacion
     */
    public static Aplicacion cargarAplicacion() {
        Aplicacion obj = null;
        
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("data.dat"));
            obj = (Aplicacion)entrada.readObject();
            entrada.close();
            aplicacion = obj;
            Usuario.setListaNombres(aplicacion.getListaNombres());
        } catch(InvalidClassException ex) {
        	obj = Aplicacion.getAplicacion();
        } catch(FileNotFoundException ex) {
            obj = Aplicacion.getAplicacion();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
    
     /**
     * Metodo para añadir un proyecto a la lista de proyectos
     * 
     * @param p Proyecto a añadir a la lista
     *      
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
     */
    public void anadirElementoColectivo(ElementoColectivo e) {
        if(listadoElementoColectivos.contains(e)) {
            return;
        }
        listadoElementoColectivos.add(e);
        return;
    }


      /**
     * Método para comprobar si un NIF pertenece a un ciudadano existente en la aplicacion
     *
     * @param str String con el NIF a comprobar
     * @return boolean, true si el NIF está usado, false en caso contrario
     */

    public boolean nifEnUso(String str) {
        for(ElementoColectivo c : listadoElementoColectivos)
            if(c.getClass().equals(Ciudadano.class))
                if(((Ciudadano)c).getNif().equals(str)){
                    return true;
                }
        return false;
    }

 
    /**
     * 
     * @param args no recibe argumentos
     * @throws Exception excepcion
     */
    public static void main(String[] args) throws Exception {
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
        d.add(Distrito.MONCLOAARAVACA);
        ProyectoInfraestructura p1 = new ProyectoInfraestructura("Puente", "Puente por encima del rio", 1000000, c1, new Imagen("planopuente.jpg","PlanoPuente"), d);
        System.out.println("\nEl colectivo " + c1 + " ha creado el proyecto " + p1);
        
        //Comprobamos que el proyecto tiene un apoyo, el del representante
        System.out.println("El proyecto " + p1 + " tiene " + p1.getApoyos() + " apoyos\n");

        //Añadimos u2 al subcolectivo c2 y comprobamos si aumenta el numero de apoyos
        System.out.println("Se une " + u2 + " al colectivo " + c2);
        p1.apoyarProyecto(u2);

        System.out.println("El proyecto " + p1 + " tiene " + p1.getApoyos() + " apoyos\n");

        //Aprobar proyecto
        aplicacion.setUsuarioActual(aplicacion.administrador);
        p1.aprobarProyecto();

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

        //Guardar Aplicacion en el archivo TuVoz.dat
        guardarAplicacion();





        Aplicacion.getAplicacion().setApoyosMin(1);
        p1.apoyarProyecto(u1);

        System.out.println("Estado del proyecto tras el apoyo: "+p1.consultarEstadoProyecto());
        
        
        
        //Enviar a financiacion


        try {
	        CCGG proxy = CCGG.getGateway();
	        proxy.setDate(FechaSimulada.getHoy());
	        p1.enviarProyecto();
	        FechaSimulada.avanzar(30);
	        proxy.setDate(FechaSimulada.getHoy());
	        p1.consultar();
	        System.out.println("Presupuesto Concedido: "+p1.getPresupuestoConcedido());
        }catch(InvalidIDException ex) {
            System.out.println(ex + ", invalid id, error en la comunicación con el sistema externo");
        } catch(InvalidRequestException e) {
        	System.out.println(e + ", invalid request, error en la comunicacoin con el sistema externo");
        }catch(IOException e) {
        	System.out.println(e);
        }
        
        System.out.println("Estado del proyecto tras el apoyo: "+p1.consultarEstadoProyecto());
    }

}
