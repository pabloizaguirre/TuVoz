
package vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import controlador.*;


public class Ventana extends JFrame {
	
	private BarraSuperior vistaBarraSuperior;
	private ControlIrAMiPerfil contIrAMiPerfil;
	private ControlIrAHome contrIrAHome;
	
	private MiPerfil vistaMiPerfil;
	private ControlIrACrearColectivo contIrACrearColectivo;
	
	private Home vistaHome;
	
	private CrearColectivo vistaCrearColectivo;
	
	private CrearProyecto vistaCrearProyecto;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	private ControlCrearProyecto contrCrearProyecto;
	
	private CrearProyectoSocial vistaCrearProyectoSocial;
	private ControlIrACrearProyectoSocial contrIrACrearProyectoSocial;
	
	private CrearProyectoInfraestructura vistaCrearProyectoInfraestructura;
	private ControlIrACrearProyectoInfraestructura contrIrACrearProyectoInfraestructura;
	
	private JPanel ventana;
	
	protected static ImageIcon createImageIcon(String path, String description) {
		if (new File(path).exists()) {
			return new ImageIcon(path, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		} 
	}
	
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,600);
		setLocationRelativeTo(null);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		ventana = new JPanel();
		ventana.setLayout(new CardLayout());
		
		JScrollPane scroll = new JScrollPane(ventana); 
		//scroll.setBorder(null);
		scroll.setPreferredSize(new Dimension(500, 300));

		this.vistaBarraSuperior = new BarraSuperior();
		contentPane.add(vistaBarraSuperior, BorderLayout.NORTH);

		//contenidos de la ventana:

		this.vistaHome = new Home();
		ventana.add(vistaHome, "home");
		
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
		
		
		vistaCrearProyecto.setControladorCrearProyecto(contrIrACrearProyecto);
		
		this.contrIrACrearProyectoSocial = controlador.getControlIrACrearProyectoSocial();
		vistaCrearProyectoSocial.setControladorCrearProyectoSocial(contrIrACrearProyectoSocial);
		
		this.contrIrACrearProyectoInfraestructura = controlador.getControlIrACrearProyectoInfraestructura();
		vistaCrearProyectoInfraestructura.setControladorCrearProyectoInfraestructura(contrIrACrearProyectoInfraestructura);
		
		
	}

	public MiPerfil getVistaMiPerfil() {
		return this.vistaMiPerfil;
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
	
	public BarraSuperior getVistaBarraSuperior() {
		return this.vistaBarraSuperior;
	}
	
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)ventana.getLayout();
		l.show(ventana, carta);
	}

}

