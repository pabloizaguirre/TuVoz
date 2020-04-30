package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

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
	private JPasswordField passwordreg;
	private JButton botonRegistro;
	
	

	public InicioRegistro() {
		SpringLayout cLayout = new SpringLayout();
		this.setLayout(cLayout);
		ImageIcon icon1 = Ventana.createImageIcon("src/icons/logo.jpneg", "Logo");
		JLabel logo = new JLabel(icon1);
		
		
		this.add(logo);
		cLayout.putConstraint(BorderLayout.EAST, logo, -400, BorderLayout.EAST, this);
		cLayout.putConstraint(BorderLayout.WEST, logo, -50, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.NORTH, logo, 50, BorderLayout.NORTH, this);	
		cLayout.putConstraint(BorderLayout.SOUTH, logo, -100, BorderLayout.SOUTH, this);	
	
		//panel de inicio de sesion
		final JPanel inicio = new JPanel();
		FlowLayout inicioLayout = new FlowLayout(FlowLayout.RIGHT);
		inicio.setLayout(inicioLayout);
		labelnombre = new JLabel("Nombre o NIF:");
		jtfnombre = new JTextField(15);
		labelpassword = new JLabel("Contraseña");
		password = new JPasswordField(10);
		botonEntrar = new JButton("Entrar");
		botonEntrar.setActionCommand("botonIniciarSesion");
		
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
		passwordreg = new JPasswordField(15);
		botonRegistro = new JButton("Registrarse");
		botonRegistro.setActionCommand("botonRegistrarse");

		registrarse.setVisible(true);

		regLayout.putConstraint(BorderLayout.NORTH, intro, 20, BorderLayout.NORTH, registrarse);
		regLayout.putConstraint(BorderLayout.NORTH, labelnifreg, 20, BorderLayout.SOUTH, intro);
		regLayout.putConstraint(BorderLayout.NORTH, jtfnifreg, 5, BorderLayout.SOUTH, labelnifreg);
		regLayout.putConstraint(BorderLayout.NORTH, labelusuarioreg, 10, BorderLayout.SOUTH, jtfnifreg);
		regLayout.putConstraint(BorderLayout.NORTH, jtfusuarioreg, 5, BorderLayout.SOUTH, labelusuarioreg);
		regLayout.putConstraint(BorderLayout.NORTH, labelpasswordreg, 10, BorderLayout.SOUTH, jtfusuarioreg);
		regLayout.putConstraint(BorderLayout.NORTH, passwordreg, 5, BorderLayout.SOUTH, labelpasswordreg); 
		regLayout.putConstraint(BorderLayout.NORTH, botonRegistro, 25, BorderLayout.SOUTH, passwordreg);
		regLayout.putConstraint(BorderLayout.WEST, intro, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, labelnifreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, jtfnifreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, labelusuarioreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, jtfusuarioreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, labelpasswordreg, 20, BorderLayout.WEST, registrarse);
		regLayout.putConstraint(BorderLayout.WEST, passwordreg, 20, BorderLayout.WEST, registrarse); 
		regLayout.putConstraint(BorderLayout.WEST, botonRegistro, 20, BorderLayout.WEST, registrarse); 
		
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
		registrarse.add(passwordreg);
		registrarse.add(botonRegistro); 
				
		this.add(registrarse);
	}

	public void setControlInicio(ActionListener c) {  
		botonEntrar.addActionListener(c);
		botonRegistro.addActionListener(c);
	}
	

	public String getNombre() {
		return jtfnombre.getText();
	}
	public String getPassword() {
		return String.valueOf(password.getPassword());

	}
	public String getNifReg() {
		return jtfnifreg.getText();
	}
	public String getUsuarioReg() {
		return jtfusuarioreg.getText();
	}
	public String getPasswordReg() {
		return String.valueOf(passwordreg.getPassword());
	}

}