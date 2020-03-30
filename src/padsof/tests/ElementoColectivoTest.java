package padsof.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import padsof.*;

import org.junit.Before;


public class ElementoColectivoTest {

	private Ciudadano u1;
	private Ciudadano u3;
    private ProyectoSocial p1;
 
 


	@Before
	public void setUp() {
		u1 = new Ciudadano("NiMalaNiSanta", "Safaera", "666");
		u3 = new Ciudadano("SoyUnico", "ChicoUnico", "00101001P");
        p1 = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, u3, "jovenes", TipoAlcance.nacional);
     
	}


    
    @Test
    public void TestAnadirAMisProyectosPropuestos(){
        u3.anadirAMisProyectosPropuestos(p1);
        
        assertTrue(u3.getProyectosPropuestos().contains(p1));
    }

    
    @Test
    public void TestAnadirAMisProyectosApoyados(){
        u1.anadirAMisProyectosApoyados(p1);
        
        assertTrue(u1.getProyectosApoyados().contains(p1));
    }

    @Test
    public void TestEliminarDeMisProyectosApoyados(){
        u1.anadirAMisProyectosApoyados(p1);
        u1.eliminarDeMisProyectosApoyados(p1);

        assertFalse(u1.getProyectosApoyados().contains(p1));
    }
}