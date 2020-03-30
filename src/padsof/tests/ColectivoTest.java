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
		fail("Not yet implemented");
	}

	@Test
	void testAbandonarColectivo() {
		fail("Not yet implemented");
	}

	@Test
	void testBucarColectivo() {
		fail("Not yet implemented");
	}

}
