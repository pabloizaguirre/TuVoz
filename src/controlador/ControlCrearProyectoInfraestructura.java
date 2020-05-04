package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import modelo.*;
import vista.*;

/**
 * Clase ControlCrearProyectoInfraestructura.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ControlCrearProyectoInfraestructura implements ActionListener {
	private CrearProyectoInfraestructura vista;
	private Ventana frame;
	private String ruta = "Unknown";
	private Controlador controlador;
	
	public ControlCrearProyectoInfraestructura(Ventana frame, Controlador contr) {
		this.frame = frame;
		this.vista = frame.getVistaCrearProyectoInfraestructura();
		this.controlador = contr;
	}

	
	/**
	 * Método para gestionar los eventos que se pueden producir en la vista de creación de 
	 * proyecto de infraestructura. Se crea proyecto de forma individual o de forma colectiva
	 * según la entrada del ComboBox de la vista
	 * 
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ProyectoInfraestructura p;
		if(e.getActionCommand().equals("crear")) {
			
			if(this.ruta.equals("Unknown") || vista.getDistritos().size()==0) {
				JOptionPane.showMessageDialog(vista,
						"Debe completar todos los apartados.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			CrearProyecto v = frame.getVistaCrearProyecto();
			 
			
			if(vista.getColectivos().equals("No")) {
				p = new ProyectoInfraestructura(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
					(Ciudadano)Aplicacion.getAplicacion().getUsuarioActual(), new Imagen(ruta, "Imagen"),getDistritoEnum());
				vista.limpiar();
				v.limpiarJtf();
			} else {
				Colectivo col = Colectivo.buscarColectivo(vista.getColectivos());
				
				p = new ProyectoInfraestructura(v.getNombre(),v.getDescripcion(),v.getPresupuesto(),
					col, new Imagen(ruta, "imagen"),getDistritoEnum());
				vista.limpiar();
				v.limpiarJtf();
			}
			
			JOptionPane.showMessageDialog(vista,
						"Proyecto creado y enviado a supervisión por parte de la Administración de Tu Voz.", "Proyecto creado", JOptionPane.INFORMATION_MESSAGE);
			
			// mostrar nueva vista
			controlador.getControlHome().addBotonProyecto(p);
			controlador.getControlMiPerfil().addBotonProyecto(p);
			frame.mostrarPanel("home");
		
		} else if(e.getActionCommand().equals("examinar")) {
			JFileChooser explorador = new JFileChooser();
	        int seleccion = explorador.showOpenDialog(null);
	        if(seleccion==JFileChooser.APPROVE_OPTION) {
	        	File archivo = explorador.getSelectedFile();
	        	this.ruta = archivo.getAbsolutePath();
	        	
		}
		}
	}
	
	/**
	 * Método para gestionar los distritos seleccionados a la hora de la creación de un proyecto
	 * de infraestructura
	 * 
	 * @param e action event
	 */
	public ArrayList<Distrito> getDistritoEnum() {
		ArrayList<String> string = vista.getDistritos();
		ArrayList<Distrito> e = new ArrayList<Distrito>();
		
		if(string.contains("ARGANZUELA")) e.add(Distrito.ARGANZUELA);
		if(string.contains("BARAJAS")) e.add(Distrito.BARAJAS);
		if(string.contains("CARABANCHEL")) e.add(Distrito.CARABANCHEL);
		if(string.contains("CENTRO")) e.add(Distrito.CENTRO);
		if(string.contains("CHAMARTIN")) e.add(Distrito.CHAMARTIN);
		if(string.contains("CHAMBERI")) e.add(Distrito.CHAMBERI);
		if(string.contains("CIUDADLINEAL")) e.add(Distrito.CIUDADLINEAL);
		if(string.contains("FUENCARRALELPARDO")) e.add(Distrito.FUENCARRALELPARDO);
		if(string.contains("HORTALEZA")) e.add(Distrito.HORTALEZA);
		if(string.contains("LATINA")) e.add(Distrito.LATINA);
		if(string.contains("MONCLOAARAVACA")) e.add(Distrito.MONCLOAARAVACA);
		if(string.contains("MORATALAZ")) e.add(Distrito.MORATALAZ);
		if(string.contains("PUENTEVALLECAS")) e.add(Distrito.PUENTEVALLECAS);
		if(string.contains("RETIRO")) e.add(Distrito.RETIRO);
		if(string.contains("SALAMANCA")) e.add(Distrito.SALAMANCA);
		if(string.contains("SANBLASCANILLEJAS")) e.add(Distrito.SANBLASCANILLEJAS);
		if(string.contains("TETUAN")) e.add(Distrito.TETUAN);
		if(string.contains("USERA")) e.add(Distrito.USERA);
		if(string.contains("VICALVARO")) e.add(Distrito.VICALVARO);
		if(string.contains("VILLAVALLECAS")) e.add(Distrito.VILLAVALLECAS);
		if(string.contains("VILLAVERDE")) e.add(Distrito.VILLAVERDE);

		return e;
	}
}
