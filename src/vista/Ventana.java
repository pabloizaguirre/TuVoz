
package vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import controlador.*;


public class Ventana extends JFrame {
	
	private MiPerfil vistaMiPerfil;
	private ControlIrACrearColectivo contIrACrearColectivo;
	
	private CrearColectivo vistaCrearColectivo;
	
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

		this.vistaMiPerfil = new MiPerfil();
		contentPane.add(vistaMiPerfil, "miPerfil");
		
		this.vistaCrearColectivo = new CrearColectivo();
		contentPane.add(vistaCrearColectivo, "crearColectivo");
	}

	public void setControlador(Controlador controlador) {
		this.contIrACrearColectivo = controlador.getControlIrACrearColectivo();
		vistaMiPerfil.setControladorAnadirColectivo(contIrACrearColectivo);
	}

	public MiPerfil getVistaMiPerfil() {
		return this.vistaMiPerfil;
	}
	
	public CrearColectivo getVistaCrearColectivo() {
		return this.vistaCrearColectivo;
	}
	
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)contentPane.getLayout();
		l.show(contentPane, carta);
	}

}

