package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import controlador.ControlDetalleProyecto;

public class DetalleProyecto extends JPanel{
	
	private JButton solicitarInforme;
	private JButton enviarAFinanciacion;
	private JButton suscribirse;
	private JButton apoyar = new JButton("");
	private JTextArea titulo = new JTextArea();
	private JLabel labelTipo = new JLabel("");
	private JPanel botones;
	private JLabel presupuestoSolicitado = new JLabel("");
	private JLabel labelEstado = new JLabel("");
	private JTextArea descripcion = new JTextArea();
	private JPanel detalles;
	private JPanel right;

	public DetalleProyecto() {
		setLayout(new BorderLayout());
		
		//panel de la derecha con la foto si tiene
		right = new JPanel();
		SpringLayout rLayout = new SpringLayout();
		right.setLayout(new FlowLayout());	
		
		//panel de la izquierda con los detalles del proyecto
		JPanel left = new JPanel();
		SpringLayout lLayout = new SpringLayout();
		left.setLayout(lLayout);
		
		titulo.setEditable(false);
		titulo.setLineWrap(true);
		titulo.setBackground(null);
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		
		labelTipo.setFont(new Font(labelTipo.getFont().getName(), Font.PLAIN, labelTipo.getFont().getSize()+2));
		
		botones = new JPanel();
		
		detalles = new JPanel();
		detalles.setLayout(new BoxLayout(detalles, BoxLayout.PAGE_AXIS));
		
		lLayout.putConstraint(BorderLayout.WEST, titulo, 20, BorderLayout.WEST, left);
		lLayout.putConstraint(BorderLayout.EAST, titulo, -20, BorderLayout.EAST, left);
		
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
		
		this.descripcion.setEditable(false);
		this.descripcion.setLineWrap(true);
		this.descripcion.setBackground(null);
		
		detalles.add(descripcion);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(presupuestoSolicitado);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(labelEstado);
		
		
		
		left.add(titulo);
		left.add(labelTipo);
		left.add(botones);
		left.add(detalles);
		
		
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.CENTER);
		
	}
	
	/*
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Mi GUI. Ejemplo 2");
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		Ciudadano c = Ciudadano.registrarCiudadano("MalaSanta", "BeckyG", "7334234P");
		Ciudadano c2 = Ciudadano.registrarCiudadano("brazos", "ConejoMalo", "1231213I");
		
		Aplicacion.getAplicacion().setUsuarioActual(c2);
		
		String desc = "Donde estan las gatas ninina palante nananinina palante... no soy ni mala ni santa ninino una como yo a ti te hace falta, calladita pero a veces soy mala empiezo y no kiero parar no soy ni mala ni santa.";
		Proyecto p = new ProyectoSocial("ONG para ayudar a victimas de belleza despampanante", desc, 123123123, c,"Pablo", TipoAlcance.INTERNACIONAL);
		List<Distrito> d = new ArrayList<Distrito>();
	    d.add(Distrito.MONCLOAARAVACA);
	    d.add(Distrito.MORATALAZ);
		Proyecto pI = new ProyectoInfraestructura("Infraestructura", desc, 2001211.123123, c2, new Imagen("/Users/casa/Desktop/IMG_0377_Facetune_27-03-2019-12-36-33.jpeg", "postu"), d);
		DetalleProyecto panel = new DetalleProyecto(pI);
		contenedor.add(panel);
		
		ControlDetalleProyecto contr = new ControlDetalleProyecto(ventana, panel, pI);
		contr.setVistaDetalleProyecto();
		
		
		
		panel.setControlador(contr);
		
		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1000,600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);	
	}*/
	
	public void setTitulo(String titulo) {
		this.titulo.append(titulo);
	}
	
	public void setLabelTipo(String tipo) {
		this.labelTipo.setText(tipo);
	}
	
	/**
	 * Establece el boton de apoyar. Si el usuario actual apoya este proyecto apoyado tiene que ser true
	 * 
	 * @param apoyado. indica si el boton debe aparecer como pulsado (true) o no (false)
	 */
	public void setApoyar(Boolean apoyado) {
		apoyar = new JButton();
		apoyar.setActionCommand("apoyar");
		if(!apoyado) {
			apoyar.setText("Apoyar");
		} else {
			apoyar.setText("Apoyado");
			apoyar.setEnabled(false);
		}
		botones.add(apoyar);
		
	}
	
	/**
	 * Establece el boton suscribirse. Si el usuario actual esta suscrito suscrito tiene que ser true
	 * 
	 * @param suscrito. indica si el boton debe aparecer como pulsado (true) o no
	 */
	public void setSuscribirse(Boolean suscrito) {
		if(suscrito) {
			suscribirse = new JButton("Suscrito");
			suscribirse.setEnabled(false);
		} else {
			suscribirse = new JButton("Suscribirse");
		}
		suscribirse.setActionCommand("suscribirse");
		botones.add(suscribirse);
	}
	
	/**
	 * Establece el boton de solicitar informe
	 */
	public void setSolicitarInforme() {
		solicitarInforme = new JButton("Solicitar informe de popularidad");
		solicitarInforme.setActionCommand("solicitarInforme");
		botones.add(solicitarInforme);
	}
	
	/**
	 * Establece el boton de enviar a financiacion
	 */
	public void setEnviarAFinanciacion() {
		enviarAFinanciacion = new JButton("Enviar a financiacion");
		enviarAFinanciacion.setActionCommand("enviarAFinanciacion");
		botones.add(enviarAFinanciacion);
	}
	
	/**
	 * Establede el presupuesto solicitado
	 * 
	 * @param presupuesto
	 */
	public void setPresupuestoSolicitado(Double presupuesto) {
		presupuestoSolicitado.setText("Presupesto solicitado: " + presupuesto + "€");
	}
	
	/**
	 * Establece el estado del proyecto
	 * @param estado String con lo que se desea meter en a etiqueta labelEstado
	 */
	public void setLabelEstado(String estado) {
		labelEstado.setText(estado);
	}
	
	/**
	 * Establece la descripcion del proyecto
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion.append("Descripcion: "+ descripcion);
	}
	
	/**
	 * Establece los jlabels opcionales en caso de que el proyecto sea de tipo social
	 * @param grupo
	 * @param sAlcance
	 */
	public void setDetallesOpcionalesSocial(String grupo, String sAlcance) {
		JLabel grupoSocial = new JLabel("Grupo social: " + grupo);
		JLabel alcance = new JLabel("Alcance: " + sAlcance);
		
		grupoSocial.setAlignmentX(LEFT_ALIGNMENT);
		alcance.setAlignmentX(LEFT_ALIGNMENT);
		
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(grupoSocial);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(alcance);
	}
	
	/**
	 * Establece los jlabels y la imagen opcionales en caso de que el proyecto sea de tipo Infraestructura
	 * @param listaDistritos
	 * @param path. Path de la imagen
	 */
	public void setDetallesOpcionalesInfraestructura(List<String> listaDistritos, String path) {
		Integer width = 300;
		
		String s = "Distritos afectados: ";
		for (String d:listaDistritos) {
			s += d + ", ";
		}
		//para quitar la ultima coma
		s = s.substring(0, s.length()-2);
		JLabel distritos = new JLabel(s);
		distritos.setAlignmentX(LEFT_ALIGNMENT);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(distritos);
		
		ImageIcon iconoImagenProyecto = Ventana.createImageIcon(path, "ImagenProyecto");
		
		if(iconoImagenProyecto != null) {
			right.setPreferredSize(new Dimension(width+40,10));
			
			Image imagenProyecto = iconoImagenProyecto.getImage();
			Integer height = (Integer) imagenProyecto.getHeight(null)*width/imagenProyecto.getWidth(null);
			imagenProyecto = imagenProyecto.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			iconoImagenProyecto.setImage(imagenProyecto);
			
			JLabel labelImagen = new JLabel(iconoImagenProyecto);
			
			right.add(labelImagen);
		}
	}
	
	public JButton getApoyar() {
		return apoyar;
	}
	
	public void resetButtonPanel() {
		botones.removeAll();
		
		if(apoyar!=null) {
			apoyar.setEnabled(true);
		}
		if(suscribirse!=null) {
			suscribirse.setEnabled(true);
		}
		if(enviarAFinanciacion!=null) {
			enviarAFinanciacion.setEnabled(true);
		}
		if(solicitarInforme!=null) {
			solicitarInforme.setEnabled(true);
		}
	}
	
	public void setControlador(ActionListener c) {
		if(apoyar!=null) {
			apoyar.addActionListener(c);
		}
		if(suscribirse!=null) {
			suscribirse.addActionListener(c);
		}
		if(enviarAFinanciacion!=null) {
			enviarAFinanciacion.addActionListener(c);
		}
		if(solicitarInforme!=null) {
			solicitarInforme.addActionListener(c);
		}
	}
}
