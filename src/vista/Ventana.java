
package vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controlador.*;
import modelo.*;


public class Ventana extends JFrame {
	
	//prueba de DetalleProyecto:
	private DetalleProyecto vistaDetalleProyecto;
	private ControlApoyar contrApoyar;
	
	
	private BarraSuperior vistaBarraSuperior;
	private ControlIrAMiPerfil contIrAMiPerfil;
	private ControlIrAHome contrIrAHome;
	
	private MiPerfil vistaMiPerfil;
	private ControlIrACrearColectivo contIrACrearColectivo;
	
	private Home vistaHome;
	private HomeAdmin vistaHomeAdmin;
	
	private CrearColectivo vistaCrearColectivo;
	private ControlCrearColectivo contrCrearColectivo;
	
	private CrearProyecto vistaCrearProyecto;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	private ControlCrearProyecto contrCrearProyecto;
	
	private CrearProyectoSocial vistaCrearProyectoSocial;
	private ControlCrearProyectoSocial contrCrearProyectoSocial;
	
	private CrearProyectoInfraestructura vistaCrearProyectoInfraestructura;
	private ControlCrearProyectoInfraestructura contrCrearProyectoInfraestructura;
	
	
	
	private ControlExaminar contrExaminar;
	
	private InicioRegistro vistaInicioRegistro;
	private ControlRegistrar contrRegistrar;
	private ControlIniciarSesion contrIniciarSesion;



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
		ventana.setPreferredSize(new Dimension(100,400));
		
		JScrollPane scroll = new JScrollPane(ventana, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		scroll.setBorder(null);

		this.vistaBarraSuperior = new BarraSuperior();
		contentPane.add(vistaBarraSuperior, BorderLayout.NORTH);
		this.vistaInicioRegistro = new InicioRegistro();
		ventana.add(vistaInicioRegistro, "inicioRegistro");
		
		
		//prueba de la pantalla de proyecto
		String descripcion = "Un proyecto rechulon para chicas malas que son rechulonas y molonas, tambien es importante que tengan alto flow, para pertenecer solo tienes que decir las palabras magicas: Que falta de respeto mami como te atreves a venir sin pantis";
		Ciudadano creador = new Ciudadano("ponbebe", "Anuel", "72231461P");
		ProyectoSocial p = new ProyectoSocial("Puente para perras", descripcion, 200000, creador, "Las chicas malas", TipoAlcance.INTERNACIONAL);
		List<Distrito> d = new ArrayList<Distrito>();
	    d.add(Distrito.MONCLOAARAVACA);
	    d.add(Distrito.MORATALAZ);
		Proyecto pInfraestructura = new ProyectoInfraestructura("Puente para conejas", descripcion, 10, creador, new Imagen("/Users/casa/Desktop/IMG_0377_Facetune_27-03-2019-12-36-33.jpeg", "postu"), d);
		
		this.vistaHome = new Home();
		ventana.add(vistaHome, "home");
		
		this.vistaDetalleProyecto = new DetalleProyecto(p);
		ventana.add(vistaDetalleProyecto, "detalleProyecto");
		
		
		
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
		
	

		contentPane.add(scroll, BorderLayout.CENTER);
	}

	public void setControlador(Controlador controlador) {
		this.contIrACrearColectivo = controlador.getControlIrACrearColectivo();
		this.contrIrACrearProyecto = controlador.getControlIrACrearProyecto();
		
		vistaHome.setControladorAnadirColectivo(contIrACrearColectivo);
		vistaHome.setControladorAnadirProyecto(contrIrACrearProyecto);
		
		
		this.contIrAMiPerfil = controlador.getControlIrAMiPerfil();
		vistaBarraSuperior.setControladorMiPerfil(contIrAMiPerfil);
		
		this.contrIrAHome = controlador.getControlIrAHome();
		vistaBarraSuperior.setControladorHome(contrIrAHome);
		
		this.contrCrearColectivo = controlador.getControlCrearColectivo();
		vistaCrearColectivo.setControladorBotonCrear(contrCrearColectivo);
		
		this.contrCrearProyecto = controlador.getControlCrearProyecto();
		vistaCrearProyecto.setControladorCrearProyecto(contrCrearProyecto);

		this.contrCrearProyectoSocial = controlador.getControlCrearProyectoSocial();
		vistaCrearProyectoSocial.setControladorCrearProyectoSocial(contrCrearProyectoSocial);

		this.contrCrearProyectoInfraestructura = controlador.getControlCrearProyectoInfraestructura();
		vistaCrearProyectoInfraestructura.setControladorCrearProyectoInfraestructura(contrCrearProyectoInfraestructura);
		
		this.contrExaminar = controlador.getControlExaminar();
		vistaCrearProyectoInfraestructura.setControladorExaminar(contrExaminar);
		
		this.contrIniciarSesion = controlador.getControlIniciarSesion();
		vistaInicioRegistro.setControlIniciarSesion(contrIniciarSesion);
		
		this.contrRegistrar = controlador.getControlRegistrar();
		vistaInicioRegistro.setControlRegistrar(contrRegistrar);
		
		this.contrApoyar = controlador.getControlApoyar();
		vistaDetalleProyecto.setControladorApoyar(contrApoyar);
		
		actualizarHome();
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
	
	public BarraSuperior getVistaBarraSuperior() {
		return this.vistaBarraSuperior;
	}
	
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)ventana.getLayout();
		l.show(ventana, carta);
	}

	public void anadirVentana(JPanel vista, String name) {
		ventana.add(vista, name);
	}
	
	public void actualizarHome() {
		vistaHome.setListaProyectos();
		
		//actualizar controladores
		ControlIrAProyecto contr;
		for(Proyecto p:Aplicacion.getAplicacion().getListadoProyectos()) {
			contr = new ControlIrAProyecto(this, p);
			vistaHome.setControladorBotonProyecto(contr, p);
		}
	}
}

