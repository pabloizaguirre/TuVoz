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
    public void TestAnadirNotificacion(){
        //Crear los objetos necesarios para la prueba
        Ciudadano c = Ciudadano.registrarCiudadano("14004", "usr1",  "78653499X");
        Notificacion n1 = new Notificacion("Bicho", c);
     
       
        //Comprobamos que la funcion devuelve false pues al crear la notificacion ya se añadio a la notificaciones del usuario
        assertFalse(c.anadirNotificacion(n1));
        
    }

    @Test
    public void TestEliminarNotificacion(){
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("14004", "usr2", "78636499J");
        Notificacion n = new Notificacion("Adios", c);
        c.anadirNotificacion(n);

        //Comprobamos que se elimina correctamente la notificacion
        assertTrue(c.eliminarNotificacion(n));
    }



}
