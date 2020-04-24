package vista;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class prueba {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Mi GUI. Ejemplo 2");
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		// crear pantalla 1
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("ARRIBA");
		JButton b2 = new JButton("ABAJO");
		p.add(b1, BorderLayout.NORTH);
		p.add(b2,BorderLayout.SOUTH);
		
		b1.setVisible(false);
		
		contenedor.add(p, BorderLayout.NORTH);
		
		ventana.pack();
		
		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1000,600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);	
	}

}
