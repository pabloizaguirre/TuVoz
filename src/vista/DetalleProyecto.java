package vista;

import java.awt.*;

import javax.swing.*;

import modelo.*;

public class DetalleProyecto extends JPanel{
	
	private JButton solicitarInforme;
	private JButton enviarAFinanciacion;
	private JButton suscribirse;
	private JButton apoyar;

	public DetalleProyecto(Proyecto proyecto) {
		setLayout(new BorderLayout());
		
		Integer tipo = 0;
		
		//panel de la izquierda con los detalles del proyecto
		JPanel left = new JPanel();
		SpringLayout lLayout = new SpringLayout();
		left.setLayout(lLayout);
		
		JLabel titulo = new JLabel(proyecto.getTitulo());
		titulo.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, titulo.getFont().getSize()+20));
		
		JPanel detalles = new JPanel();
		detalles.setLayout(new BoxLayout(detalles, BoxLayout.PAGE_AXIS));
		
		JLabel labelTipo;
		if(proyecto instanceof ProyectoSocial) {
			tipo = 1;
			labelTipo = new JLabel("Proyecto social");
		} else {
			labelTipo = new JLabel("Proyecto de infraestructura");
		}
		labelTipo.setFont(new Font(labelTipo.getFont().getName(), Font.PLAIN, labelTipo.getFont().getSize()+2));
		
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
		
		lLayout.putConstraint(BorderLayout.NORTH, detalles, 20, BorderLayout.SOUTH, labelTipo);
		lLayout.putConstraint(BorderLayout.WEST, detalles, 22, BorderLayout.WEST, left);
		lLayout.putConstraint(BorderLayout.EAST, detalles, 0, BorderLayout.EAST, left);
		
		
		presupuestoSolicitado.setAlignmentX(LEFT_ALIGNMENT);
		labelEstado.setAlignmentX(LEFT_ALIGNMENT);
		descripcion.setAlignmentX(LEFT_ALIGNMENT);
		
		detalles.add(descripcion);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(presupuestoSolicitado);
		detalles.add(Box.createRigidArea(new Dimension(0, 5)));
		detalles.add(labelEstado);
		
		
		if(tipo==0) {
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
		left.add(detalles);
		
		//panel de la derecha con los botones
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.PAGE_AXIS));
		/*SpringLayout rLayout = new SpringLayout();
		right.setLayout(rLayout);*/
		right.setPreferredSize(new Dimension(300, 100));
		
		solicitarInforme = new JButton("Solicitar informe de popularidad");
		enviarAFinanciacion = new JButton("Enviar a financiacion");
		suscribirse = new JButton("Suscribirse");
		apoyar = new JButton("Apoyar");
		
		/*rLayout.putConstraint(BorderLayout.NORTH, apoyar, 0, BorderLayout.SOUTH, titulo);
		rLayout.putConstraint(BorderLayout.EAST, apoyar, -20, BorderLayout.EAST, right);
		
		rLayout.putConstraint(BorderLayout.NORTH, suscribirse, 5, BorderLayout.SOUTH, apoyar);
		rLayout.putConstraint(BorderLayout.EAST, suscribirse, -20, BorderLayout.EAST, right);
		
		rLayout.putConstraint(BorderLayout.NORTH, solicitarInforme, 5, BorderLayout.SOUTH, suscribirse);
		rLayout.putConstraint(BorderLayout.EAST, solicitarInforme, -20, BorderLayout.EAST, right);
		
		rLayout.putConstraint(BorderLayout.NORTH, enviarAFinanciacion, 5, BorderLayout.SOUTH, solicitarInforme);
		rLayout.putConstraint(BorderLayout.EAST, enviarAFinanciacion, -20, BorderLayout.EAST, right);
		*/
		
		apoyar.setAlignmentX(RIGHT_ALIGNMENT);
		suscribirse.setAlignmentX(RIGHT_ALIGNMENT);
		solicitarInforme.setAlignmentX(RIGHT_ALIGNMENT);
		enviarAFinanciacion.setAlignmentX(RIGHT_ALIGNMENT);
		
		right.add(Box.createRigidArea(new Dimension(0, 30)));
		right.add(apoyar);
		right.add(Box.createRigidArea(new Dimension(0, 5)));
		right.add(suscribirse);
		right.add(Box.createRigidArea(new Dimension(0, 5)));
		right.add(solicitarInforme);
		right.add(Box.createRigidArea(new Dimension(0, 5)));
		right.add(enviarAFinanciacion);
		
		
		
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.CENTER);
		
	}
}
