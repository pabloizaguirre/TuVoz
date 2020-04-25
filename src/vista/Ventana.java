
package vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import controlador.*;


public class Ventana extends JFrame {
	
	private BarraSuperior vistaBarraSuperior;
	private ControlIrAMiPerfil contIrAMiPerfil;
	
	private MiPerfil vistaMiPerfil;
	private ControlIrACrearColectivo contIrACrearColectivo;
	
	private CrearColectivo vistaCrearColectivo;
	
	private CrearProyecto vistaCrearProyecto;
	private ControlIrACrearProyecto contrIrACrearProyecto;
	
	private CrearProyectoSocial vistaCrearProyectoSocial;
	private ControlIrACrearProyectoSocial contrIrACrearProyectoSocial;
	
	private CrearProyectoInfraestructura vistaCrearProyectoInfraestructura;
	private ControlIrACrearProyectoInfraestructura contrIrACrearProyectoInfraestructura;
	
	private JPanel contentPane;
	
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
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		
		this.vistaBarraSuperior = BarraSuperior.getBarraSuperior();

		this.vistaMiPerfil = new MiPerfil();
		contentPane.add(vistaMiPerfil, "miPerfil");
		
		this.vistaCrearColectivo = new CrearColectivo();
		contentPane.add(vistaCrearColectivo, "crearColectivo");
		
		this.vistaCrearProyecto = new CrearProyecto();
		contentPane.add(vistaCrearProyecto, "crearProyecto");
		
		this.vistaCrearProyectoSocial = new CrearProyectoSocial();
		contentPane.add(vistaCrearProyectoSocial, "crearProyectoSocial");
		
		this.vistaCrearProyectoInfraestructura = new CrearProyectoInfraestructura();
		contentPane.add(vistaCrearProyectoInfraestructura, "crearProyectoInfraestructura");
	}

	public void setControlador(Controlador controlador) {
		this.contIrACrearColectivo = controlador.getControlIrACrearColectivo();
		vistaMiPerfil.setControladorAnadirColectivo(contIrACrearColectivo);
		this.contrIrACrearProyecto = controlador.getControlIrACrearProyecto();
		vistaMiPerfil.setControladorAnadirProyecto(contrIrACrearProyecto);
		
		this.contIrAMiPerfil = controlador.getControlIrAMiPerfil();
		vistaBarraSuperior.setControladorMiPerfil(contIrAMiPerfil);
		
		
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
		CardLayout l = (CardLayout)contentPane.getLayout();
		l.show(contentPane, carta);
	}

}

