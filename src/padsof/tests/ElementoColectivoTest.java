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
        foto = new Imagen("Maqueta complejo")
		u1 = new Ciudadano("NiMalaNiSanta", "Safaera", "666");
		u2 = new Ciudadano("AquiLlegoTuTiburon", "ConejoMalo", "12312332W");
		u3 = new Ciudadano("SoyUnico", "ChicoUnico", "00101001P");
		c1 = new Colectivo("Voluntariado", u1);
        c2 = new Colectivo("Apoyo a ancianos", c1);
        p1 = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, ciudadano, "jovenes", 0);
        p2 = new ProyectoInfraestructura("Uranizacion", "Creacion de un nuevo coomplejo", 2700000, u1, foto)
	}

    @Test
    public TestAnadirAMisProyectosApoyados{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(12234, localHost0, 96456332J, false);
        Ciudadano ciudadano = new Ciudadano(14009, usrr,  99636499T, false);
        

        //Comprobamos que se añade correctamente el proyecto de la lista de suscritos
        assertTrue(c.anadirAMisProyectosApoyados(p)==true);
    }
}