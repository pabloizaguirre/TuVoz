package vista;

import java.awt.*;
import javax.swing.*;

public class CrearProyectoSocial {
	public static void main (String args[]) {
		JFrame ventana = new JFrame("Crear proyecto");
		
		Container contenedor = ventana.getContentPane();
		SpringLayout cLayout = new SpringLayout();
		contenedor.setLayout(cLayout);
		
		JPanel barra = new BarraSuperior();
		barra.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel labelNuevo = new JLabel("Nuevo proyecto social");
		
		JLabel labelGrupoSocial = new JLabel("Grupo social: ");
		JTextField jtfGrupoSocial = new JTextField(20);
		
		JLabel labelAmbito = new JLabel("Seleccione ámbito del proyecto:");
		JRadioButton nacional = new JRadioButton("Nacional");
		JRadioButton internacional = new JRadioButton("Internacional");
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(nacional);
		grupoBotones.add(internacional);
		
		JPanel panelProyecto = new JPanel(new GridLayout(2,2));
		panelProyecto.add(labelGrupoSocial);
		panelProyecto.add(jtfGrupoSocial);
		panelProyecto.add(labelAmbito);
		JPanel panelBotones = new JPanel();
		panelBotones.add(nacional);
		panelBotones.add(internacional);
		panelProyecto.add(panelBotones);
		
		
		JPanel panelCrear = new JPanel(new BorderLayout());
		
		panelCrear.add(barra, BorderLayout.NORTH);
		panelCrear.add(labelNuevo, BorderLayout.WEST);
		panelCrear.add(panelProyecto, BorderLayout.SOUTH);
		
		
		
		JPanel panelBoton = new JPanel(new BorderLayout());
		panelBoton.add(new JButton("Crear"), BorderLayout.SOUTH);
		
	
		
		
		//contenedor.add(barra);
		
		cLayout.putConstraint(BorderLayout.WEST, panelCrear, 40, BorderLayout.WEST, contenedor);
		cLayout.putConstraint(BorderLayout.SOUTH, panelBoton, 40, BorderLayout.SOUTH, contenedor);


		contenedor.add(panelCrear);
		
		contenedor.add(panelBoton);
		
		
		
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setSize(1920,1080);
		ventana.setVisible(true);
	}
	
}
