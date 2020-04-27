package modelo;
/**
 * Enumeracion de los tipos de proyectos.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */


public enum TipoAlcance {
    NACIONAL, INTERNACIONAL;
	
	@Override
	public String toString() {
		if(this.equals(NACIONAL)) {
			return "nacional";
		} else {
			return "internacional";
		}
	}
}