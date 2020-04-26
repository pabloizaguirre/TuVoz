package vista;

import java.awt.*;

import javax.swing.*;

import modelo.*;

public class DetalleProyecto extends JPanel{

	public DetalleProyecto(Proyecto proyecto) {
		setLayout(new BorderLayout());
		
		Integer tipo = 0;
		
		JPanel left = new JPanel();
		SpringLayout lLayout = new SpringLayout();
		left.setLayout(lLayout);
		left.setBorder(BorderFactory.createLineBorder(Color.red));
		
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
		labelTipo.setFont(new Font(labelTipo.getFont().getName(), Font.PLAIN, labelTipo.getFont().getSize()+20));
		
		JLabel presupuestoSolicitado = new JLabel("Presupesto solicitado: " + proyecto.getPresupuestoSolicitado() + "€");
		
		EstadoProyecto estado = proyecto.getEstado();
		JLabel labelEstado;
		if(estado.equals(EstadoProyecto.APROBADO)) {
			labelEstado = new JLabel("Estado: " + estado + ", con presupuesto concedido de " + proyecto.getPresupuestoConcedido() + "€");
		} else {
			labelEstado = new JLabel("Estado: " + estado);
		}
		
		JLabel descripcion = new JLabel("Descripcion: " + proyecto.getDescripcion());
		
		lLayout.putConstraint(BorderLayout.WEST, titulo, 20, BorderLayout.WEST, left);
		
		lLayout.putConstraint(BorderLayout.NORTH, labelTipo, 5, BorderLayout.SOUTH, titulo);
		lLayout.putConstraint(BorderLayout.WEST, labelTipo, 25, BorderLayout.WEST, left);
		
		lLayout.putConstraint(BorderLayout.NORTH, detalles, 20, BorderLayout.SOUTH, labelTipo);
		lLayout.putConstraint(BorderLayout.WEST, detalles, 40, BorderLayout.WEST, left);
		lLayout.putConstraint(BorderLayout.EAST, detalles, 0, BorderLayout.EAST, left);
		
		
		/*presupuestoSolicitado.setAlignmentX(LEFT_ALIGNMENT);
		labelEstado.setAlignmentX(LEFT_ALIGNMENT);
		descripcion.setAlignmentX(LEFT_ALIGNMENT);*/
		
		detalles.add(presupuestoSolicitado);
		detalles.add(labelEstado);
		detalles.add(descripcion);
		
		if(tipo==0) {
			String s = "Distritos afectados: ";
			for (Distrito d:((ProyectoInfraestructura)proyecto).getDistritosAfectados()) {
				s += d + ", ";
			}
			//para quitar la ultima coma
			s = s.substring(0, s.length()-2);
			JLabel distritos = new JLabel(s);
			distritos.setAlignmentX(LEFT_ALIGNMENT);
			detalles.add(distritos);
		} else {
			JLabel grupoSocial = new JLabel(((ProyectoSocial) proyecto).getGrupoSocial());
			JLabel alcance = new JLabel(((ProyectoSocial) proyecto).getAlcance().toString());
			
			grupoSocial.setAlignmentX(LEFT_ALIGNMENT);
			alcance.setAlignmentX(LEFT_ALIGNMENT);
			
			detalles.add(grupoSocial);
			detalles.add(alcance);
		}
		
		left.add(titulo);
		left.add(labelTipo);
		left.add(detalles);
		
		add(left, BorderLayout.CENTER);
		
	}
}
