package modelo.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import modelo.Ciudadano;
import modelo.Notificacion;
import modelo.*;

public class UsuarioTest {


    @Test
    public void TestNombreEnUso(){
        //Crear los objetos necesarios para la prueba
        Ciudadano.registrarCiudadano("NiMalaNiSanta", "Safaera", "666");

        //Comprobamos que se devuelve lo esperado
        assertTrue(Ciudadano.nombreEnUso("Safaera"));
        assertFalse(Ciudadano.nombreEnUso("Sara"));

    }

    @Test
    public void TestEliminarNotificacion(){
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("14004", "usr2", "78636499J");
        assertEquals(2, Aplicacion.getAplicacion().getAdministrador().getNotificaciones().size());

        Aplicacion.getAplicacion().getAdministrador().eliminarNotificacion(Aplicacion.getAplicacion().getAdministrador().getNotificaciones().get(0));
        assertEquals(1, Aplicacion.getAplicacion().getAdministrador().getNotificaciones().size());
    }



}
