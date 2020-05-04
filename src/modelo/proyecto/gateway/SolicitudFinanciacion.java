package modelo.proyecto.gateway;

import es.uam.eps.sadp.grants.*;
import modelo.proyecto.Proyecto;
import modelo.proyecto.ProyectoInfraestructura; 

/**
 * Clase para solicitar la financiacion de un proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class SolicitudFinanciacion implements GrantRequest {
	Proyecto p; 
	
	public SolicitudFinanciacion(Proyecto p) {
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
