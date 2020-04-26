package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class InicioRegistro extends JPanel {

	private JLabel labelnombre;
	private JTextField jtfnombre;
	private JLabel labelpassword;
	private JPasswordField password;
	private JButton botonEntrar;

	private JLabel labelnifreg;
	private JTextField jtfnifreg;
	private JLabel labelusuarioreg;
	private JTextField jtfusuarioreg;
	private JLabel labelpasswordreg;
	private JTextField jtfpasswordreg;
	private JButton buttonregistro;
	

	public InicioRegistro() {
		SpringLayout cLayout = new SpringLayout();
		this.setLayout(cLayout);
		
	
		//panel de inicio de sesion
		final JPanel inicio = new JPanel();
		FlowLayout inicioLayout = new FlowLayout(FlowLayout.RIGHT);
		inicio.setLayout(inicioLayout);
		labelnombre = new JLabel("Nombre o NIF:");
		jtfnombre = new JTextField(15);
		labelpassword = new JLabel("Contraseña");
		password = new JPasswordField(10);
		botonEntrar = new JButton("Entrar");
		
		inicio.add(labelnombre);
		inicio.add(jtfnombre);
		inicio.add(labelpassword);
		inicio.add(password);
		inicio.add(botonEntrar);
		
		cLayout.putConstraint(BorderLayout.WEST, inicio, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.EAST, inicio, -40, BorderLayout.EAST, this);
				

		this.add(inicio);
		
		
		
		
		//panel de registro
		final JPanel registrarse = new JPanel();
		SpringLayout regLayout = new SpringLayout();
		registrarse.setLayout(regLayout);
		registrarse.setBorder(BorderFactory.createLineBorder(Color.blue));
		JLabel intro = new JLabel("Crear una cuenta");
		intro.setFont(new Font(intro.getFont().getName(), Font.PLAIN, intro.getFont().getSize()+15));

		labelnifreg = new JLabel("NIF:");
		jtfnifreg = new JTextField(15);
		labelusuarioreg = new JLabel("Usuario");
		jtfusuarioreg = new JTextField(15);
		labelpasswordreg = new JLabel("Contraseña");
		jtfpasswordreg = new JTextField(15);
		buttonregistro = new JButton("Registrarse");

		registrarse.setVisible(true);

		regLayout.putConstraint(BorderLayout.NORTH, intro, -380, BorderLayout.SOUTH, registrarse);
		regLayout.putConstraint(BorderLayout.NORTH, labelnifreg, 20, BorderLayout.SOUTH, intro);
		regLayout.putConstraint(BorderLayout.NORTH, jtfnifreg, 5, BorderLayout.SOUTH, labelnifreg);
		regLayout.putConstraint(BorderLayout.NORTH, labelusuarioreg, 10, BorderLayout.SOUTH, jtfnifreg);
		regLayout.putConstraint(BorderLayout.NORTH, jtfusuarioreg, 5, BorderLayout.SOUTH, labelusuarioreg);
		regLayout.putConstraint(BorderLayout.NORTH, labelpasswordreg, 10, BorderLayout.SOUTH, jtfusuarioreg);
		regLayout.putConstraint(BorderLayout.NORTH, jtfpasswordreg, 5, BorderLayout.SOUTH, labelpasswordreg); 
		regLayout.putConstraint(BorderLayout.NORTH, buttonRegistro, 25, BorderLayout.SOUTH, jtfpasswordreg);
		regLayout.putConstraint(BorderLayout.WEST, intro, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, labelnifreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, jtfnifreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, labelusuarioreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, jtfusuarioreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, labelpasswordreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, jtfpasswordreg, 20, BorderLayout.WEST, registrarse); 
		regLayout.putConstraint(BorderLayout.WEST, buttonRegistro, 20, BorderLayout.WEST, registrarse); 
		
		cLayout.putConstraint(BorderLayout.EAST, registrarse, -50, BorderLayout.EAST, this);
		cLayout.putConstraint(BorderLayout.WEST, registrarse, -400, BorderLayout.EAST, this);
		cLayout.putConstraint(BorderLayout.NORTH, registrarse, 40, BorderLayout.SOUTH, inicio);	
		cLayout.putConstraint(BorderLayout.SOUTH, registrarse, -100, BorderLayout.SOUTH, this);	
		
		registrarse.add(intro);
		registrarse.add(labelnifreg);
		registrarse.add(jtfnifreg);
		registrarse.add(labelusuarioreg);
		registrarse.add(jtfusuarioreg);
		registrarse.add(labelpasswordreg);
		registrarse.add(jtfpasswordreg);
		registrarse.add(buttonRegistro); 
				
		this.add(registrarse);
	}

	public void setControladorEntrarApp(ActionListener c) {  
		botonEntrar.addActionListener(c);
	}
	
	public void setControladorRegistrarse(ActionListener c) {  
		buttonRegistro.addActionListener(c);
	}

	public String getNombre() {
		return jtfnombre.getText();
	}
	public String getPassword() {
		return password.getText();
	}
	public String getNifReg() {
		return jtfnifreg.getText();
	}
	public String getUsuarioReg() {
		return jtfusuarioreg.getText();
	}
	public String getPasswordReg() {
		return jtfusuarioreg.getText();
	}

}