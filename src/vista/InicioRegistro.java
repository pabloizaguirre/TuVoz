package vista;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class InicioRegistro {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Inicio/Registro");
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		SpringLayout cLayout = new SpringLayout();
		contenedor.setLayout(cLayout);
		
		
		// crear pantalla 1
		
		final JPanel inicio = new JPanel();
		FlowLayout inicioLayout = new FlowLayout(FlowLayout.RIGHT);
		inicio.setLayout(inicioLayout);
		JLabel labelnombre = new JLabel("Nombre o NIF:");
		JTextField jtfnombre = new JTextField(15);
		JLabel labelpassword = new JLabel("Contraseña");
		JPasswordField password = new JPasswordField(10);
		JButton entrar = new JButton("Entrar");
		
		inicio.add(labelnombre);
		inicio.add(jtfnombre);
		inicio.add(labelpassword);
		inicio.add(password);
		inicio.add(entrar);
		
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.WEST, inicio, 40, BorderLayout.WEST, contenedor);
		cLayout.putConstraint(BorderLayout.EAST, inicio, -40, BorderLayout.EAST, contenedor);
				
		// anadir componentes al contenedor
		contenedor.add(inicio);
		
		
		
		
		//Crear pantalla 2
		
		final JPanel registrarse = new JPanel();
		SpringLayout regLayout = new SpringLayout();
		registrarse.setLayout(regLayout);
		JLabel intro = new JLabel("Crea una cuenta");
		JLabel labelnifreg = new JLabel("NIF:");
		JTextField jtfnifreg = new JTextField(15);
		JLabel labelusuarioreg = new JLabel("Usuario");
		JTextField jtfusuarioreg = new JTextField(15);
		JLabel labelpasswordreg = new JLabel("Contraseña");
		JTextField jtfpasswordreg = new JTextField(15);
		JButton buttonregistro = new JButton("Registrarse");
		
		registrarse.add(intro);
		registrarse.add(labelnifreg);
		registrarse.add(jtfnifreg);
		registrarse.add(labelusuarioreg);
		registrarse.add(jtfusuarioreg);
		registrarse.add(labelpasswordreg);
		registrarse.add(jtfpasswordreg);
		registrarse.add(buttonregistro);
		
		registrarse.setVisible(true);
		
		regLayout.putConstraint(BorderLayout.EAST, intro, -70, BorderLayout.EAST, contenedor);
		regLayout.putConstraint(BorderLayout.NORTH, intro, 120, BorderLayout.NORTH, contenedor);
				
		//añadir constraints del contenedor
		cLayout.putConstraint(BorderLayout.EAST, registrarse, -70, BorderLayout.EAST, contenedor);
		cLayout.putConstraint(BorderLayout.NORTH, registrarse, 120, BorderLayout.NORTH, contenedor);
				
		// anadir componentes al contenedor
		contenedor.add(registrarse);

	
		
		ventana.pack();
		
		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1000,600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);	
	}
}
