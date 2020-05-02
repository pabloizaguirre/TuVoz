
package vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controlador.*;
import modelo.*;


public class Ventana extends JFrame {
	
	//prueba de DetalleProyecto:
	private DetalleProyecto vistaDetalleProyecto;
	private ControlApoyar contrApoyar;
	
	
	private BarraSuperior vistaBarraSuperior;
	private ControlBarraSuperior contrBarraSuperior;
	
	private MiPerfil vistaMiPerfil;
	private ControlIrACrearColectivo contIrACrearColectivo;
	
	private Home vistaHome;
	private ControlHome contrHome;

	private HomeAdmin vistaHomeAdmin;
	private ControlHomeAdmin contrHomeAdmin;
	
	private ApoyoMinimoProyecto vistaApoyoMinimoProyecto;
	private ControlApoyoMinimoProyecto contrApoyoMinimoProyecto;
	
	private CrearColectivo vistaCrearColectivo;
	private ControlCrearColectivo contrCrearColectivo;
	
	private CrearProyecto vistaCrearProyecto;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	private ControlCrearProyecto contrCrearProyecto;
	
	private CrearProyectoSocial vistaCrearProyectoSocial;
	private ControlCrearProyectoSocial contrCrearProyectoSocial;
	
	private CrearProyectoInfraestructura vistaCrearProyectoInfraestructura;
	private ControlCrearProyectoInfraestructura contrCrearProyectoInfraestructura;
	
	private VerNotificaciones vistaNotificaciones;
	private ControlNotificaciones contrNoti;
	
	private HashMap<Integer, ControlDetalleProyecto> proyectos = new HashMap<Integer, ControlDetalleProyecto>();
	private HashMap<String, ControlDetalleColectivo> colectivos = new HashMap<String, ControlDetalleColectivo>();
	
	
	
	private InicioRegistro vistaInicioRegistro;
	private ControlInicio contrInicio;


	private String ultimaVista;
	private JPanel ventana;
	
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
		setSize(new Dimension(1000,600));
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
		
		//Aplicacion.getAplicacion().cargarAplicacion();
		
		
		//prueba de la pantalla de proyecto
		String descripcion = "Un proyecto rechulon para chicas malas que son rechulonas y molonas, tambien es importante que tengan alto flow, para pertenecer solo tienes que decir las palabras magicas: Que falta de respeto mami como te atreves a venir sin pantis";
		Ciudadano creador = new Ciudadano("ponbebe", "Anuel", "72231461P");
		ProyectoSocial p = new ProyectoSocial("Puente", descripcion, 200000, creador, "Las chicas malas", TipoAlcance.INTERNACIONAL);
		List<Distrito> d = new ArrayList<Distrito>();
	    d.add(Distrito.MONCLOAARAVACA);
	    d.add(Distrito.MORATALAZ);
		Proyecto pInfraestructura = new ProyectoInfraestructura("Puente para conejas", descripcion, 10, creador, new Imagen("/Users/casa/Downloads/guinea-pig-bridge-1.jpg", "postu"), d);
		
		creador.aprobarRegistro();
		
		Ciudadano punkizius = new Ciudadano ("badg" , "Punkizius", "123456789A");
		punkizius.aprobarRegistro();
		
		//No consigo que se muestre el colectivo en la pestaña para seleccionar colectivos al crear
		//un proyecto
		
		Colectivo colectivo = new Colectivo("Coquito CF", creador);
		
		creador.anadirAMisColectivosCreados(colectivo);

		
		
		
		this.vistaHome = new Home();
		ventana.add(vistaHome, "home");
		
		//this.vistaDetalleProyecto = new DetalleProyecto(p);
		//ventana.add(vistaDetalleProyecto, "detalleProyecto");
		
		
		
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
		this.contIrACrearColectivo = controlador.getControlIrACrearColectivo();
		this.contrIrACrearProyecto = controlador.getControlIrACrearProyecto();
		
		vistaHome.setControladorAnadirColectivo(contIrACrearColectivo);
		vistaHome.setControladorAnadirProyecto(contrIrACrearProyecto);
		
		
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
		
		this.contrNoti = controlador.getControlNotificaciones();
		vistaNotificaciones.setControlNotificaciones(contrNoti);
		
	
		//this.contrApoyar = controlador.getControlApoyar();
		//vistaDetalleProyecto.setControlador(contrApoyar);
		
		// Establecer controlador Home
		this.contrHome = controlador.getControlHome();
		
		this.contrHomeAdmin = controlador.getControlHomeAdmin();
		vistaHomeAdmin.setControlHomeAdmin(contrHomeAdmin);
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
	
	public HashMap<Integer, ControlDetalleProyecto> getProyectos(){
		return this.proyectos;
	}
	
	public HashMap<String, ControlDetalleColectivo> getColectivos(){
		return this.colectivos;
	}
	
	public String getUltimaVista() {
		return ultimaVista;
	}
	
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)ventana.getLayout();
		ultimaVista = carta;
		l.show(ventana, carta);
	}
	
	public void panelAnterior() {
		CardLayout l = (CardLayout)ventana.getLayout();
		l.previous(ventana);
	}

	public void anadirVentana(JPanel vista, String name) {
		ventana.add(vista, name);
	}
	
	public void resetHome() {
		contrHome.setVista();
		vistaHome.setControladorAnadirColectivo(contIrACrearColectivo);
		vistaHome.setControladorAnadirProyecto(contrIrACrearProyecto);
	}
}

