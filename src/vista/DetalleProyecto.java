package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import modelo.*;

public class DetalleProyecto extends JPanel{
	
	private JButton solicitarInforme;
	private JButton enviarAFinanciacion;
	private JButton suscribirse;
	private JButton apoyar;
	private Proyecto proy;

	public DetalleProyecto(Proyecto proyecto) {
		proy = proyecto;
		setLayout(new BorderLayout());
		
		Integer tipo = 0;
		Usuario usuarioActual = Aplicacion.getAplicacion().getUsuarioActual();
		
		//panel de la derecha con la foto si tiene
		JPanel right = new JPanel();
		SpringLayout rLayout = new SpringLayout();
		right.setLayout(rLayout);	
		
		
		//panel de la izquierda con los detalles del proyecto
		JPanel left = new JPanel();
		SpringLayout lLayout = new SpringLayout();
		left.setLayout(lLayout);
		
		JLabel titulo = new JLabel(proyecto.getTitulo());
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		
		JLabel labelTipo;
		if(proyecto instanceof ProyectoSocial) {
			tipo = 1;
			labelTipo = new JLabel("Proyecto social");
		} else {
			labelTipo = new JLabel("Proyecto de infraestructura");
		}
		labelTipo.setFont(new Font(labelTipo.getFont().getName(), Font.PLAIN, labelTipo.getFont().getSize()+2));
		
		JPanel botones = new JPanel();
		
		solicitarInforme = new JButton("Solicitar informe de popularidad");
		enviarAFinanciacion = new JButton("Enviar a financiacion");
		suscribirse = new JButton("Suscribirse");
		
		if(!proyecto.getListadoApoyos().contains(usuarioActual)) {
			apoyar = new JButton("Apoyar");
		} else {
			apoyar = new JButton("Apoyado");
			apoyar.setEnabled(false);
		}
		if(!proyecto.getListadoSuscripciones().contains(usuarioActual)) {
			suscribirse = new JButton("Suscribirse");
		} else {
			suscribirse = new JButton("Suscrito");
			suscribirse.setEnabled(false);
		}
		botones.add(apoyar);
		botones.add(suscribirse);
		if(proyecto.getCreador().equals(usuarioActual)) {
			botones.add(solicitarInforme);
			if(proyecto.getEstado().equals(EstadoProyecto.DISPONIBLE)) {
				botones.add(enviarAFinanciacion);
			}
		}
		
		
		JPanel detalles = new JPanel();
		detalles.setLayout(new BoxLayout(detalles, BoxLayout.PAGE_AXIS));
		
		JLabel presupuestoSolicitado = new JLabel("Presupesto solicitado: " + proyecto.getPresupuestoSolicitado() + "€");
		
		EstadoProyecto estado = proyecto.getEstado();
		JLabel labelEstado;
		if(estado.equals(EstadoProyecto.APROBADO)) {
			labelEstado = new JLabel("Estado: " + estado + ", con presupuesto concedido de " + proyecto.getPresupuestoConcedido() + "€");
		} else {
			labelEstado = new JLabel("Estado: " + estado);
		}
		
		//JLabel descripcion = new JLabel("Descripcion: " + proyecto.getDescripcion());
		JTextArea descripcion = new JTextArea();
		descripcion.append("Descripcion: " + proyecto.getDescripcion());
		descripcion.setEditable(false);
		descripcion.setLineWrap(true);
		descripcion.setBackground(null);
		
		lLayout.putConstraint(BorderLayout.WEST, titulo, 20, BorderLayout.WEST, left);
		
		lLayout.putConstraint(BorderLayout.NORTH, labelTipo, 0, BorderLayout.SOUTH, titulo);
		lLayout.putConstraint(BorderLayout.WEST, labelTipo, 22, BorderLayout.WEST, left);
		
		lLayout.putConstraint(BorderLayout.NORTH, botones, 5, BorderLayout.SOUTH, labelTipo);
		lLayout.putConstraint(BorderLayout.WEST, botones, 20, BorderLayout.WEST, left);
		
		lLayout.putConstraint(BorderLayout.NORTH, detalles, 15, BorderLayout.SOUTH, botones);
		lLayout.putConstraint(BorderLayout.WEST, detalles, 22, BorderLayout.WEST, left);
		lLayout.putConstraint(BorderLayout.EAST, detalles, -22, BorderLayout.EAST, left);
		
		
		presupuestoSolicitado.setAlignmentX(LEFT_ALIGNMENT);
		labelEstado.setAlignmentX(LEFT_ALIGNMENT);
		descripcion.setAlignmentX(LEFT_ALIGNMENT);
		
		detalles.add(descripcion);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(presupuestoSolicitado);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(labelEstado);
		
		
		if(tipo==0) {
			right.setPreferredSize(new Dimension(300,300));
			String s = "Distritos afectados: ";
			for (Distrito d:((ProyectoInfraestructura)proyecto).getDistritosAfectados()) {
				s += d + ", ";
			}
			//para quitar la ultima coma
			s = s.substring(0, s.length()-2);
			JLabel distritos = new JLabel(s);
			distritos.setAlignmentX(LEFT_ALIGNMENT);
			left.add(Box.createRigidArea(new Dimension(0, 5)));
			detalles.add(distritos);
			
			ImageIcon imagenProyecto = Ventana.createImageIcon(((ProyectoInfraestructura)proyecto).getImagen().getPath(), ((ProyectoInfraestructura)proyecto).getImagen().getNombre());
			JLabel labelImagen = new JLabel(imagenProyecto);
			rLayout.putConstraint(BorderLayout.WEST, labelImagen, 20, BorderLayout.WEST, right);
			rLayout.putConstraint(BorderLayout.EAST, labelImagen, -20, BorderLayout.EAST, right);
			rLayout.putConstraint(BorderLayout.SOUTH, labelImagen, 0, BorderLayout.SOUTH, right);
			right.add(labelImagen);
		} else {
			JLabel grupoSocial = new JLabel("Grupo social: " + ((ProyectoSocial) proyecto).getGrupoSocial());
			JLabel alcance = new JLabel("Alcance: " + ((ProyectoSocial) proyecto).getAlcance());
			
			grupoSocial.setAlignmentX(LEFT_ALIGNMENT);
			alcance.setAlignmentX(LEFT_ALIGNMENT);
			
			detalles.add(Box.createRigidArea(new Dimension(0, 5)));
			detalles.add(grupoSocial);
			detalles.add(Box.createRigidArea(new Dimension(0, 5)));
			detalles.add(alcance);
		}
		
		left.add(titulo);
		left.add(labelTipo);
		left.add(botones);
		left.add(detalles);
		
		
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.CENTER);
		
	}
	
	public Proyecto getProyecto() {
		return proy;
	}
	
	public JButton getApoyar() {
		return apoyar;
	}
	
	public void setControladorApoyar(ActionListener c) {  
		apoyar.addActionListener(c);
	}
	
	public void setControladorSuscribirse(ActionListener c) {  
		suscribirse.addActionListener(c);
	}
	
	public void setControladorEnviarAFinanciacion(ActionListener c) {  
		enviarAFinanciacion.addActionListener(c);
	}
	
	public void setControladorSolicitarInforme(ActionListener c) {  
		solicitarInforme.addActionListener(c);
	}
	
}
