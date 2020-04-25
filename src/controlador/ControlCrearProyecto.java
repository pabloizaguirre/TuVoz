package controlador;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlCrearProyecto implements ActionListener{
    private CrearProyecto vista;
    private Ventana frame;
    
    public ControlCrearProyecto(Ventana frame) {
        this.frame = frame;
		this.vista = frame.getVistaCrearProyecto();
    }

    /**
	 * Cambia la vista a CrearProyecto
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

        // validar valores en la vista
		
        if (vista.getNombre().equals("") || vista.getDescripcion().equals("") || vista.getPresupuesto()==-1.0
            || vista.getTipoProyecto().equals(null)) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
        if (vista.getTipoProyecto().equals(TipoProyecto.social)) {
            frame.mostrarPanel("crearProyectoSocial");
        } else {
            frame.mostrarPanel("crearProyectoInfraestructura");
        }
		
	}
}