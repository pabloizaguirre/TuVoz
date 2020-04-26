package vista;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import modelo.TipoAlcance;

public class CrearProyectoSocial extends JPanel {
	
	private JTextField jtfGrupoSocial;
	private JRadioButton nacional;
	private JRadioButton internacional;
	private JButton botonCrear;
	
	public CrearProyectoSocial() {
		
			
		SpringLayout cLayout = new SpringLayout();
		setLayout(cLayout);
		
		JLabel labelNuevo = new JLabel("Nuevo proyecto social");
		
		JLabel labelGrupoSocial = new JLabel("Grupo social: ");
		jtfGrupoSocial = new JTextField(20);
		
		JLabel labelAlcance = new JLabel("Seleccione ámbito del proyecto:");
		nacional = new JRadioButton("Nacional");
		internacional = new JRadioButton("Internacional");
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(nacional);
		grupoBotones.add(internacional);
		
		JPanel panelProyecto = new JPanel(new GridLayout(2,2));
		panelProyecto.add(labelGrupoSocial);
		panelProyecto.add(jtfGrupoSocial);
		panelProyecto.add(labelAlcance);
		JPanel panelBotones = new JPanel();
		panelBotones.add(nacional);
		panelBotones.add(internacional);
		panelProyecto.add(panelBotones);
		
		
		JPanel panelCrear = new JPanel(new BorderLayout());
		
		panelCrear.add(labelNuevo, BorderLayout.WEST);
		panelCrear.add(panelProyecto, BorderLayout.SOUTH);
		
		
		
		JPanel panelBoton = new JPanel(new BorderLayout());
		botonCrear = new JButton("Crear");
		panelBoton.add(botonCrear, BorderLayout.SOUTH);
		
		cLayout.putConstraint(BorderLayout.WEST, panelCrear, 40, BorderLayout.WEST, this);
		cLayout.putConstraint(BorderLayout.SOUTH, panelBoton, 40, BorderLayout.SOUTH, this);


		JPanel panelPrincipal = new JPanel();
		
		panelPrincipal.add(panelCrear);
		panelPrincipal.add(panelBoton);
		
		add(panelPrincipal);
		
	}
	
	public void setControladorCrearProyectoSocial(ActionListener c) {  
		botonCrear.addActionListener(c);
	}

	public String getGrupoSocial() {
		return jtfGrupoSocial.getText();
	}
	public TipoAlcance getTipoAlcance() {
		if(nacional.isSelected()) {
			return TipoAlcance.nacional;
		}
		else if(internacional.isSelected()) {
			return TipoAlcance.internacional;
		}
		else {
			return null;
		}
	}
	
}
