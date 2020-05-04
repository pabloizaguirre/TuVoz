package modelo.proyecto;
/**
 * Enumeracion de los estados de proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

 /**pendienteCreacion: Proyecto no autorizado por el administrador
  * noEnviado: Proyecto no enviado a financiación
  * disponible: El proyecto ha alcanzado los apoyos mínimos
  * pendienteAprobacion: Proyecto enviado al sistema externo
  * aprobado: Proyecto autorizado por el sistema externo
  * rechazado: Proyecto desechado por el sistema externo
  * caducado: Proyecto que ha lleva más de 30 días sin recibir apoyos
  */

public enum EstadoProyecto {
    PENDIENTECREACION,NOENVIADO,DISPONIBLE,PENDIENTEFINANCIACION,FINANCIADO,RECHAZADO,CADUCADO;
	
	@Override
	public String toString() {
		if (this.equals(PENDIENTECREACION)) {
			return "pendiente de ser aprobado por el administrador";
		} else if (this.equals(NOENVIADO)) {
			return "en proceso de obtener el numero suficiente de apoyos";
		} else if (this.equals(DISPONIBLE)) {
			return "listo para enviar a financiación";
		} else if (this.equals(PENDIENTEFINANCIACION)) {
			return "pendiente de ser financiado";
		} else if (this.equals(FINANCIADO)) {
			return "financiado";
		} else if (this.equals(RECHAZADO)) {
			return "rechazado";
		} else {
			return "caducado";
		}
	}
}