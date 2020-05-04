package controlador;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import modelo.*;
import vista.*;

/**
 * Clase ControlCrearProyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlCrearProyecto implements ActionListener{
    private CrearProyecto vista;
    private Ventana frame;
    
    public ControlCrearProyecto(Ventana frame) {
        this.frame = frame;
		this.vista = frame.getVistaCrearProyecto();
    }

    /**
	 * Método para gestionar los eventos que se pueden producir en la vista de creación
	 * de un nuevo proyecto
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        double presupuesto;
        // validar valores en la vista
        try {
            presupuesto = vista.getPresupuesto();
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(vista,
					"Debe introducir un numero en el campo de presupuesto", "Error", JOptionPane.ERROR_MESSAGE);
			return;
        }
		
        if (vista.getNombre().equals("") || vista.getDescripcion().equals("")
            || vista.getTipoProyecto().equals(null)) {
			JOptionPane.showMessageDialog(vista,
					"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (presupuesto < 0) {
			JOptionPane.showMessageDialog(vista,
					"El presupuesto tiene que ser mayor o igual a cero", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (vista.getNombre().length()>25) {
			JOptionPane.showMessageDialog(vista,
					"El titulo es demasiado largo.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (vista.getDescripcion().length()>500) {
			JOptionPane.showMessageDialog(vista,
					"La descipcion es demasiado larga.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
        if (vista.getTipoProyecto().equals("social")) {
        	CrearProyectoSocial.addColectivos(((Ciudadano)Aplicacion.getAplicacion().getUsuarioActual()).getColectivosCreados());
            frame.mostrarPanel("crearProyectoSocial");
        } else {
        	setDistritos();
        	CrearProyectoInfraestructura.addColectivos(((Ciudadano)Aplicacion.getAplicacion().getUsuarioActual()).getColectivosCreados());
            frame.mostrarPanel("crearProyectoInfraestructura");
        }
		
	}
	
	/**
	 * Método para gestionar los botones de los distritos que se pueden elegir a la hora de crear
	 * un proyecto de infraestructura
	 * 
	 */
	public void setDistritos() {
		ArrayList<JCheckBox> distritos = new ArrayList<JCheckBox>();
		
		distritos.add(new JCheckBox(Distrito.ARGANZUELA.toString()));
		distritos.add(new JCheckBox(Distrito.BARAJAS.toString()));
		distritos.add(new JCheckBox(Distrito.CARABANCHEL.toString()));
		distritos.add(new JCheckBox(Distrito.CENTRO.toString()));
		distritos.add(new JCheckBox(Distrito.CHAMARTIN.toString()));
		distritos.add(new JCheckBox(Distrito.CHAMBERI.toString()));
		distritos.add(new JCheckBox(Distrito.CIUDADLINEAL.toString()));
		distritos.add(new JCheckBox(Distrito.FUENCARRALELPARDO.toString()));
		distritos.add(new JCheckBox(Distrito.HORTALEZA.toString()));
		distritos.add(new JCheckBox(Distrito.LATINA.toString()));
		distritos.add(new JCheckBox(Distrito.MONCLOAARAVACA.toString()));
		distritos.add(new JCheckBox(Distrito.MORATALAZ.toString()));
		distritos.add(new JCheckBox(Distrito.PUENTEVALLECAS.toString()));
		distritos.add(new JCheckBox(Distrito.RETIRO.toString()));
		distritos.add(new JCheckBox(Distrito.SALAMANCA.toString()));
		distritos.add(new JCheckBox(Distrito.SANBLASCANILLEJAS.toString()));
		distritos.add(new JCheckBox(Distrito.TETUAN.toString()));
		distritos.add(new JCheckBox(Distrito.USERA.toString()));
		distritos.add(new JCheckBox(Distrito.VICALVARO.toString()));
		distritos.add(new JCheckBox(Distrito.VILLAVALLECAS.toString()));
		distritos.add(new JCheckBox(Distrito.VILLAVERDE.toString()));

		CrearProyectoInfraestructura.addDistritos(distritos);
		
		
	}
}