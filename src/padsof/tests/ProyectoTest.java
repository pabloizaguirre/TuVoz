package padsof.tests;
import static org.junit.Assert.*;
import org.junit.Test;

import padsof.*;

import org.junit.Before;
import java.util.*;

public class ProyectoTest {

    private Ciudadano u1;
	private Ciudadano u2;
    private Ciudadano u3;
    private Ciudadano u4;
    private Ciudadano u5;
    private Ciudadano u6;
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
        u4 = new Ciudadano("DivaVirtual", "Omarito", "07801003H");
        u5 = new Ciudadano("Mercadona", "LaBadgy", "07803303M");
        u6 = new Ciudadano("Love", "Sxe", "07803305C");
		c1 = new Colectivo("Voluntariado", u1);
        c2 = new Colectivo("Apoyo a ancianos", c1);
        p1 = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, u3, "jovenes", 0);
        p2 = new ProyectoInfraestructura("Uranizacion", "Creacion de un nuevo coomplejo", 2700000, u3, foto);
	}

    
    
    @Test
    public void testApoyarProyecto(){

        //Comprobar que los resultados son correctos
        assertEquals(p1.getApoyos(), 1);

        //Dos personas apoyan el proyecto
        p1.apoyarProyecto(u1);
        p1.apoyarProyecto(u2);

        //Comprobar que ahora el numero de apoyos es 3
        assertEquals(p1.getApoyos(), 3);
        
        //Una persona que ya lo habia apoyado apoya el proyecto de nuevo
        p1.apoyarProyecto(u1);

        //Comprobar que el numero de apoyos sigue siendo 3
        assertEquals(p1.getApoyos(), 3);

        //Un colectivo apoya este proyecto
        c1.unirseAColectivo(u4);
        c1.unirseAColectivo(u5);
        p1.apoyarProyecto(c1);

        //Comprobamos
        assertEquals(p1.getApoyos(), 5);

        //un ciudadano bloqueado apoya el proyecto
        u5.bloquearCiudadano();
        p1.apoyarProyecto(u6);

        //Comprobamos que no ha aumentado el numero de apoyos
        assertEquals(p1.getApoyos(), 5);

        //bloqueamos a un ciudadano que lo haba apoyado
        u1.bloquearCiudadano();

        //Comprobamos que se retira el apoyo de ese ciudadano
        assertEquals(p1.getApoyos(), 4);
    }

    @Test
    public void testEliminarApoyo(){
        //Comprobar que los resultados son correctos
        assertEquals(p1.getApoyos(), 1);

        //Dos personas apoyan el proyecto
        p1.apoyarProyecto(u1);
        p1.apoyarProyecto(u2);

        //Comprobar que ahora el numero de apoyos es 3
        assertEquals(p1.getApoyos(), 3);

        //Rl u1 retira su apoyo al proyecto
        p1.eliminarapoyo(u1);

        //Comprobar que ahora el numero de apoyos es 2
        assertEquals(p1.getApoyos(), 2);

    }

    @Test
    public void testSuscribirProyecto{
        //El u1 se suscribe a p1
        p1.suscrbirproyecto(u1);

        //Comprobamos que se añade correctamente a la lista de suscritos
        assertTrue(u1.getProyectosSuscritos.contains(p1));
        assertTrue(p1.getListadoSuscripciones.contains(u1));

    }



}