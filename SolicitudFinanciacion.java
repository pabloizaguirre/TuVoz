import es.uam.eps.sadp.grants.*;

public class SolicitudFinanciacion implements GrantRequest {
	Proyecto p; 
	SolicitudFinanciacion(Proyecto p) {this.p=p;}
	public String getExtraData() {
		return "extraData";
	}
	public String getProjectDescription() {
		return "descripcion";
	}
	public ProjectKind getProjectKind() {
		return GrantRequest.ProjectKind.valueOf("Social");
	}
	public String getProjectTitle() {
		return p.titulo;
	}
	public double getRequestedAmount() {
		return 1000;
	}
}