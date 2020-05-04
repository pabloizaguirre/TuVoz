package modelo;

import es.uam.eps.sadp.grants.*; 

/**
 * Clase para solicitar la financiacion de un proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class SolicitudFinanciacion implements GrantRequest {
	Proyecto p; 
	
	SolicitudFinanciacion(Proyecto p) {
		this.p=p;
	}
	
	public String getExtraData() {
		return "extraData";
	}
	public String getProjectDescription() {
		return p.getDescripcion();
	}

	
	/**
     * Método que devuelve el tipo del proyecto actual
     *
     * @return ProjectKind que es el tipo del proyecto
     */
	public ProjectKind getProjectKind() {
		if(p.getClass().equals(ProyectoInfraestructura.class)){
			return ProjectKind.Infrastructure;
		}
		else {
			return ProjectKind.Social;
		}
		
	}
	public String getProjectTitle() {
		return p.getTitulo();
	}
	public double getRequestedAmount() {
		return p.getPresupuestoSolicitado();
	}
} 
