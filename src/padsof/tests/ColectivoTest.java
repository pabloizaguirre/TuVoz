package padsof.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import padsof.*;

public class ColectivoTest {
	private Ciudadano u1;
	private Ciudadano u2;
	private Ciudadano u3;
	private Colectivo c1;
	private Colectivo c2;


	@Before
	public void setUp() {
		u1 = new Ciudadano("NiMalaNiSanta", "Safaera", "666");
		u2 = new Ciudadano("AquiLlegoTuTiburon", "ConejoMalo", "12312332W");
		u3 = new Ciudadano("SoyUnico", "ChicoUnico", "00101001P");
		c1 = new Colectivo("Voluntariado", u1);
		c2 = new Colectivo("Apoyo a ancianos", c1);

		c2.unirseAColectivo(u2);

	}


	@Test
	public void testEsMiembro() {
		boolean resultado1 = c1.esMiembro(u1);
		boolean resultado2 = c1.esMiembro(u2);
		boolean resultado3 = c2.esMiembro(u2);
		boolean resultado4 = c2.esMiembro(u1);
		boolean resultado5 = c1.esMiembro(u3);

		assertTrue(resultado1);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertFalse(resultado4);
		assertFalse(resultado5);

	}

	@Test
	void testUnirseAColectivo() {
		Ciudadano u4 = new Ciudadano("aaaa", "Bernarda Alba", "0000000N");
		boolean resultado1 = c1.esMiembro(u4);

		assertFalse(resultado1)
	}

	@Test
	void testAnadirSubcolectivo() {
		c1.anadirSubcolectivo(c2);

		assertTrue(c1.getElementos.contains(c2));
	}

	@Test
	void testAnadirAProyectosApoyados{
		ProyectoSocial p1 = new ProyectoSocial("prueba1","Este es un proyecto de prueba1", 200000, c1, "jovenes1", 0);

		c1.testAnadirAProyectosApoyados(p1);
		assertTrue(c1.getProyectosApoyados().contains(p1));
	}


	@Test
	void testAbandonarColectivo() {
		c1.unirseAColectivo(u1);
		c1.abandonarColectivo(u1);

		assertFalse(c1.getElementos().contains(u1));
	}

	@Test
	void testBucarColectivo() {

		assertSame(c1, u2.buscarColectivo("Voluntariado"));
		
	}

}
