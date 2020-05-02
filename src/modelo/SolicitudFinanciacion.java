package modelo;

import es.uam.eps.sadp.grants.*; 

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
