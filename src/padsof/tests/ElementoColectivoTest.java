package padsof.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import padsof.Ciudadano;

import org.junit.Before;
import java.util.*;

public class ElementoColectivoTest {

	private Ciudadano u1;
	private Ciudadano u2;
	private Ciudadano u3;
	private Colectivo c1;
    private Colectivo c2;
    private ProyectoSocial p1;
    private ProyectoInfraestructura p2;
    private Imagen foto;


	@Before
	public void setUp() {
        foto = new Imagen("Maqueta complejo");
		u1 = new Ciudadano("NiMalaNiSanta", "Safaera", "666");
		u2 = new Ciudadano("AquiLlegoTuTiburon", "ConejoMalo", "12312332W");
		u3 = new Ciudadano("SoyUnico", "ChicoUnico", "00101001P");
		c1 = new Colectivo("Voluntariado", u1);
        c2 = new Colectivo("Apoyo a ancianos", c1);
        p1 = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, u3, "jovenes", 0);
        p2 = new ProyectoInfraestructura("Uranizacion", "Creacion de un nuevo coomplejo", 2700000, u3, foto);
	}


    
    @Test
    public TestAnadirAMisProyectosPropuestos{
        u3.anadirAMisProyectospropuestos(p1);
        
        assertTrue(u3.getProyectosPropuestos.contains(p1));
    }

    
    @Test
    public TestAnadirAMisProyectosApoyados{
        u1.anadirAMisProyectosApoyados(p1);
        
        assertTrue(u1.getProyectosApoyados.contains(p1));
    }

    @Test
    public TesteliminarDeMisProyectosApoyados{
        u1.anadirAMisProyectosApoyados(p1);
        u1.eliminarDemisproyectosapoyados(p1);

        assertTrue(u1.getProyectosApoyados.contains(p1));
    }
}