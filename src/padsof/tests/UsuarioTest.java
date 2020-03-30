package padsof.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import padsof.Ciudadano;

import org.junit.Before;
import java.util.*;

public class CiudadanoTest {


    //TESTS COPIADOS Y PEGADOS XQ LOS HABIA HECHO PARA CIUDADANO REVISAR!

    @Test
    public TestAnadirNotificacion{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(14004, usr1,  78653499X, false);
        Notificacion n = new Notificacion("Hola", c);

        //Comprobamos que se anade correctamente la notificacion al usuario
        assertTrue(c.anadirNotificacion(n)==true);
    }

    @Test
    public TestEliminarNotificacion{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(14004, usr2,  78636499J, false);
        Notificacion n = new Notificacion("Adios", c);
        c.anadirNotificacion(n);

        //Comprobamos que se elimina correctamente la notificacion al usuario
        assertTrue(c.eliminarNotificacion(n)==true);
    }



}
