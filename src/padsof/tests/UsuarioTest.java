package padsof.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import padsof.Ciudadano;

import org.junit.Before;
import java.util.*;

public class CiudadanoTest {


    @Test
    public void TestNombreEnUso(){
        //Crear los objetos necesarios para la prueba
        Ciudadano c1= Ciudadano.registarCiudadano("NiMalaNiSanta", "Safaera", "666");

        //Comprobamos que se devuelve lo esperado
        assertTrue(Usuario.nobreEnUso("Safaera"));
        assertFalse(Usuario.nobreEnUso("Sara"));

    }


    @Test
    public TestAnadirNotificacion{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(14004, usr1,  78653499X, false);
        Notificacion n = new Notificacion("Hola", c);

        //Comprobamos que se manda correctamente la notificacion al usuario
        assertTrue(c.anadirNotificacion(n)==true);
    }

    @Test
    public TestEliminarNotificacion{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(14004, usr2,  78636499J, false);
        Notificacion n = new Notificacion("Adios", c);
        c.anadirNotificacion(n);

        //Comprobamos que se elimina correctamente la notificacion
        assertTrue(c.eliminarNotificacion(n)==true);
    }



}
