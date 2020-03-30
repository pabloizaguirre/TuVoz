package padsof.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import padsof.*;

class ColectivoTest {
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
		c2 = new Colectivo("Apoyo a ancianos", u1, c1);

		c2.unirseAColectivo(u2);

	}


	@Test
	void testEsMiembro() {
		boolean resultado1 = c1.esMiembro(u1);
		boolean resultado2 = c1.esMiembro(u2);
		boolean resultado3 = c2.esMiembro(u2);
		boolean resultado4 = c2.esMiembro(u1);
		boolean resultado5 = c1.esMiembro(u3);

		assertTrue(resultado1 == true);
		assertTrue(resultado2 == true);
		assertTrue(resultado3 == true);
		assertFalse(resultado4 == true);
		assertFalse(resultado5 == true);

	}

	@Test
	void testUnirseAColectivo() {
		Ciudadano u4 = new Ciudadano("aaaa", "Bernarda Alba", "0000000N");
		boolean resultado1 = c1.esMiembro(u4);

		assertTrue(resultado1 == false)
	}

	@Test
	void testAnadirSubcolectivo() {
		c1.anadirSubcolectivo(c2);

		assertTrue(elementos.contains(c2) == true)
	}

	@Test
	void testAbandonarColectivo() {
		c1.unirseAColectivo(u1);
		c1.abandonarColectivo(u1);

		assertTrue(elementos.contains(u1) == false)
	}

	@Test
	void testBucarColectivo() {
		
	}

}
