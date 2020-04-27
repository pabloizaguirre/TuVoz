package vista;

import java.awt.BorderLayout;

import javax.swing.*;

public class VerNotificaciones extends JPanel{
	
	private JLabel noticiulabel;
	
	public VerNotificaciones(){
		BoxLayout notiLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(notiLayout);
		JLabel intro = new JLabel ("Notificaciones");
		this.add(intro);
		
		
    }
    
	public void NotificacionesCiudadanoProyecto(Notificacion texto) {
			final JPanel noticiup = new JPanel();
			BoxLayout layoutNoticiup = new BoxLayout(noticiup, BoxLayout.Y_AXIS);
			noticiup.setLayout(layoutNoticiup);
			noticiulabel = new JLabel(texto);
		}
}