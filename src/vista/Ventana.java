
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controlador.*;
import modelo.*;

/**
 * Clase de la vista Ventana.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class Ventana extends JFrame {
	
	//prueba de DetalleProyecto:
	private DetalleProyecto vistaDetalleProyecto;
	
	
	private BarraSuperior vistaBarraSuperior;
	private ControlBarraSuperior contrBarraSuperior;
	
	private MiPerfil vistaMiPerfil;
	private ControlMiPerfil contrMiPerfil;
	
	private Home vistaHome;
	private ControlHome contrHome;

	private HomeAdmin vistaHomeAdmin;
	private ControlHomeAdmin contrHomeAdmin;
	
	private ApoyoMinimoProyecto vistaApoyoMinimoProyecto;
	private ControlApoyoMinimoProyecto contrApoyoMinimoProyecto;
	
	private CrearColectivo vistaCrearColectivo;
	private ControlCrearColectivo contrCrearColectivo;
	
	private CrearProyecto vistaCrearProyecto;
	private ControlCrearProyecto contrCrearProyecto;
	
	private CrearProyectoSocial vistaCrearProyectoSocial;
	private ControlCrearProyectoSocial contrCrearProyectoSocial;
	
	private CrearProyectoInfraestructura vistaCrearProyectoInfraestructura;
	private ControlCrearProyectoInfraestructura contrCrearProyectoInfraestructura;
	
	private VerNotificaciones vistaNotificaciones;
	private ControlNotificaciones contrNotificaciones;
	
	private HashMap<Integer, ControlDetalleProyecto> proyectos = new HashMap<Integer, ControlDetalleProyecto>();
	private HashMap<String, ControlDetalleColectivo> colectivos = new HashMap<String, ControlDetalleColectivo>();
	
	
	
	private InicioRegistro vistaInicioRegistro;
	private ControlInicio contrInicio;


	private String ultimaVista;
	private String vistaActual;
	private JPanel ventana;
	
	/**
     * Metodo para crear un ImageIcon a partir de un archivo 
     * @param path, ruta del archivo
     * @param description, descripcion a añadir 
     * 
     * @return ImageIcon deseada, null en caso de error
     * 
     */
	public static ImageIcon createImageIcon(String path, String description) {
		if (new File(path).exists()) {
			return new ImageIcon(path, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		} 
	}
	
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Aplicacion.guardarAplicacion();
                e.getWindow().dispose();
            }
        });
		setSize(new Dimension(1000,600));
		setMinimumSize(new Dimension(720,200));
		setLocationRelativeTo(null);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		ventana = new JPanel();
		ventana.setLayout(new CardLayout());
		ventana.setPreferredSize(new Dimension(100,500));
		
		JScrollPane scroll = new JScrollPane(ventana, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		scroll.setBorder(null);

		this.vistaBarraSuperior = new BarraSuperior();
		contentPane.add(vistaBarraSuperior, BorderLayout.NORTH);
		vistaBarraSuperior.setVisible(false);
		
		this.vistaInicioRegistro = new InicioRegistro();
		ventana.add(vistaInicioRegistro, "inicioRegistro");
		ultimaVista = "inicioRegistro";
		
		
		
		//prueba de la pantalla de proyecto
		/*Ciudadano creador = new Ciudadano("ponbebe", "Anuel", "72231461P");
		creador.aprobarRegistro();
		Ciudadano punkizius = new Ciudadano ("badg" , "Punkizius", "123456789A");
		punkizius.aprobarRegistro();*/
		
		
		
		this.vistaHome = new Home();
		ventana.add(vistaHome, "home");
		
		//contenidos de la ventana:

		
		
		this.vistaHomeAdmin = new HomeAdmin();
		ventana.add(vistaHomeAdmin, "homeAdmin");
		
		this.vistaMiPerfil = new MiPerfil();
		ventana.add(vistaMiPerfil, "miPerfil");
		
		this.vistaCrearColectivo = new CrearColectivo();
		ventana.add(vistaCrearColectivo, "crearColectivo");
		
		this.vistaCrearProyecto = new CrearProyecto();
		ventana.add(vistaCrearProyecto, "crearProyecto");
		
		this.vistaCrearProyectoSocial = new CrearProyectoSocial();
		ventana.add(vistaCrearProyectoSocial, "crearProyectoSocial");
		
		this.vistaCrearProyectoInfraestructura = new CrearProyectoInfraestructura();
		ventana.add(vistaCrearProyectoInfraestructura, "crearProyectoInfraestructura");
		
		this.vistaNotificaciones = new VerNotificaciones();
		ventana.add(vistaNotificaciones, "notificaciones");
		
		this.vistaApoyoMinimoProyecto = new ApoyoMinimoProyecto();
		ventana.add(vistaApoyoMinimoProyecto, "apoyoMinimoProyecto");
		
	
		
		contentPane.add(scroll, BorderLayout.CENTER);
	}

	public void setControlador(Controlador controlador) {
		
		this.contrBarraSuperior = controlador.getControlBarraSuperior();
		vistaBarraSuperior.setControlador(contrBarraSuperior);
	
		
		this.contrCrearColectivo = controlador.getControlCrearColectivo();
		vistaCrearColectivo.setControladorBotonCrear(contrCrearColectivo);
		
		this.contrCrearProyecto = controlador.getControlCrearProyecto();
		vistaCrearProyecto.setControladorCrearProyecto(contrCrearProyecto);

		this.contrCrearProyectoSocial = controlador.getControlCrearProyectoSocial();
		vistaCrearProyectoSocial.setControladorCrearProyectoSocial(contrCrearProyectoSocial);

		this.contrCrearProyectoInfraestructura = controlador.getControlCrearProyectoInfraestructura();
		vistaCrearProyectoInfraestructura.setControladorCrearProyectoInfraestructura(contrCrearProyectoInfraestructura);
		
		this.contrApoyoMinimoProyecto = controlador.getControlApoyoMinimoProyecto();
		vistaApoyoMinimoProyecto.setControlApoyoProyecto(contrApoyoMinimoProyecto);
		
		this.contrInicio = controlador.getControlInicio();
		vistaInicioRegistro.setControlInicio(contrInicio);
		
		
		this.contrMiPerfil = controlador.getControlMiPerfil();
		vistaMiPerfil.setControlador(contrMiPerfil);
		
		
		// Establecer controlador Home
		this.contrHome = controlador.getControlHome();
		vistaHome.setControlador(contrHome);
		
		this.contrHomeAdmin = controlador.getControlHomeAdmin();
		vistaHomeAdmin.setControlHomeAdmin(contrHomeAdmin);
		
		this.contrNotificaciones = controlador.getControlNotificaciones();
	}
	
	public DetalleProyecto getVistaDetalleProyecto() {
		return this.vistaDetalleProyecto;
	}

	public MiPerfil getVistaMiPerfil() {
		return this.vistaMiPerfil;
	}
	public Home getVistaHome() {
		return this.vistaHome;
	}
	public HomeAdmin getVistaHomeAdmin() {
		return this.vistaHomeAdmin;
	}
	
	public CrearColectivo getVistaCrearColectivo() {
		return this.vistaCrearColectivo;
	}
	
	public CrearProyecto getVistaCrearProyecto() {
		return this.vistaCrearProyecto;
	}
	
	public CrearProyectoSocial getVistaCrearProyectoSocial() {
		return this.vistaCrearProyectoSocial;
	}
	
	public CrearProyectoInfraestructura getVistaCrearProyectoInfraestructura() {
		return this.vistaCrearProyectoInfraestructura;
	}
	
	public InicioRegistro getVistaInicioRegistro() {
		return this.vistaInicioRegistro;
	}
	public VerNotificaciones getVistaNotificaciones(){
		return this.vistaNotificaciones;
	}
	public BarraSuperior getVistaBarraSuperior() {
		return this.vistaBarraSuperior;
	}
	
	public ApoyoMinimoProyecto getVistaApoyoMinimoProyecto() {
		return this.vistaApoyoMinimoProyecto;
	}
	
	public ControlHome getControlHome() {
		return this.contrHome;
	}
	
	public ControlMiPerfil getControlMiPerfil() {
		return this.contrMiPerfil;
	}
	
	public HashMap<Integer, ControlDetalleProyecto> getProyectos(){
		return this.proyectos;
	}
	
	public HashMap<String, ControlDetalleColectivo> getColectivos(){
		return this.colectivos;
	}
	
	public String getUltimaVista() {
		return ultimaVista;
	}
	 /**
     * Metodo para mostrar el panel requerido pasado por parametro
     * @param carta, String de la vista a mostrar
     * 
     */
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)ventana.getLayout();
		ultimaVista = vistaActual;
		vistaActual = carta;
		l.show(ventana, carta);
	}
	
	public void panelAnterior() {
		CardLayout l = (CardLayout)ventana.getLayout();
		l.previous(ventana);
	}
	 /**
     * Metodo para añadir un boton a la lista de botones de proyectos 
     * @param boton Boton que queremos añadir
     * 
     */
	public void anadirVentana(JPanel vista, String name) {
		ventana.add(vista, name);
	}
	 /**
     * Metodo para resetear la vista de Home
     * 
     */
	public void resetHome() {
		contrHome.setVista();
		
	}
}

