package modelo.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import modelo.*;
import modelo.proyecto.ProyectoSocial;
import modelo.proyecto.TipoAlcance;

import org.junit.Before;

/**
 * Tester de elemento colectivo.
 *
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class ElementoColectivoTest {

	private Ciudadano u1;
	private Ciudadano u3;
    private ProyectoSocial p1;
 
 


	/**
    * Crea ciudadanos y un proyecto para usarlos en los testers
    *
    */
	@Before
	public void setUp() {
		u1 = new Ciudadano("NiMalaNiSanta", "Safaera", "666");
		u3 = new Ciudadano("SoyUnico", "ChicoUnico", "00101001P");
        p1 = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, u3, "jovenes", TipoAlcance.NACIONAL);
     
	}


    
	/**
    * Comprueba que un proyecto se añada a la lista de los proyectos propuestos por un elemento colectivo
    *
    */
    @Test
    public void TestAnadirAMisProyectosPropuestos(){
        u3.anadirAMisProyectosPropuestos(p1);
        
        assertTrue(u3.getProyectosPropuestos().contains(p1));
    }

    /**
    * Comprueba que un proyecto se añada a la lista de los proyectos apoyados por un elemento colectivo
    *
    */
    @Test
    public void TestAnadirAMisProyectosApoyados(){
        u1.anadirAMisProyectosApoyados(p1);
        
        assertTrue(u1.getProyectosApoyados().contains(p1));
    }

    /**
    * Comprueba que un proyecto se elimina de la lista de los proyectos apoyados por un elemento colectivo
    *
    */
    @Test
    public void TestEliminarDeMisProyectosApoyados(){
        u1.anadirAMisProyectosApoyados(p1);
        u1.eliminarDeMisProyectosApoyados(p1);

        assertFalse(u1.getProyectosApoyados().contains(p1));
    }
}