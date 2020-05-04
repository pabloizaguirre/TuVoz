package modelo.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Ciudadano;
import modelo.Colectivo;
import modelo.ProyectoSocial;
import modelo.TipoAlcance;
import modelo.*;

/**
 * Tester de colectivo.
 *
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */
public class ColectivoTest {
	private Ciudadano u1;
	private Ciudadano u2;
	private Ciudadano u3;
	private Colectivo c1;
	private Colectivo c2;

	/**
    * Crea ciudadanos y colectivos para usarlos en los testers
    *
    */
	@BeforeEach
	public void setUp(){
		u1 = new Ciudadano("NiMalaNiSanta", "Safaera", "666");
		u2 = new Ciudadano("AquiLlegoTuTiburon", "ConejoMalo", "12312332W");
		u3 = new Ciudadano("SoyUnico", "ChicoUnico", "00101001P");
		c1 = new Colectivo("Atletismo", u1);
		c2 = new Colectivo("Apoyo a ancianos", c1);

		c2.unirseAColectivo(u2); 
	}

	/**
    * Comprueba que el ciudadano es miembro colectivo
    *
    */
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

	/**
    * Comprueba se une correctamente al colectivo
    *
    */
	@Test
	void testUnirseAColectivo() {
		Ciudadano u4 = new Ciudadano("aaaa", "Bernarda Alba", "0000000N");
		boolean resultado = c1.esMiembro(u4);
		assertFalse(resultado);
		
		c2.unirseAColectivo(u4);
		
		resultado = c1.esMiembro(u4);
		assertTrue(resultado);
	}

	/**
    * Comprueba se une correctamente al subcolectivo
    *
    */
	@Test
	void testAnadirSubcolectivo() {
		c1.anadirSubcolectivo(c2);

		assertTrue(c1.getElementos().contains(c2));
		assertTrue(c1.esMiembro(c2));
	}

	/**
    * Comprueba que un proyecto se añade correctamente a la lista de proyectos apoyados por ese ciudadano
    *
    */
	@Test
	void testAnadirAProyectosApoyados() {
		ProyectoSocial p1 = new ProyectoSocial("prueba1","Este es un proyecto de prueba1", 200000, c1, "jovenes1", TipoAlcance.NACIONAL);

		c1.anadirAProyectosApoyados(p1);
		assertTrue(c1.getProyectosApoyados().contains(p1));
	}

	/**
    * Comprueba que un ciudadano abandone correctamente un colectivo
    *
    */
	@Test
	void testAbandonarColectivo() {
		assertTrue(c1.esMiembro(u2));
		c1.abandonarColectivo(u1);

		assertFalse(c1.getElementos().contains(u1));
	}
	
	/**
    * Comprueba que funcione la busqueda de colectivos
    *
    */
	@Test
	void testBuscarColectivo() {
		Colectivo c3 = new Colectivo("Pruebita guay", u1);
		assertSame(c3,Colectivo.buscarColectivo("Pruebita guay"));
	}

}
