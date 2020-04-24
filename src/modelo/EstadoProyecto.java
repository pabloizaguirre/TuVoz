package modelo;
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
    pendienteCreacion,noEnviado,disponible,pendienteAprobacion,aprobado, rechazado, caducado;
}