package padsof.tests;
import static org.junit.Assert.*;
import org.junit.Test;

import padsof.*;

import org.junit.Before;
import java.util.*;

public class ProyectoTest {

    
    /* Falta: Comprobar que la lista de elementos que apoyan es correcta */
    @Test
    public void testApoyarProyecto(){
        //Creamos los objetos necesarios para la prueba
        Ciudadano[] users = new Ciudadano[5];
        /* Falta: crear los ciudadanos */

        /* Falta: registrar los 3 primeros ciudadanos */

        ProyectoInfraestructura p1 = new ProyectoInfraestructura(/* Argumentos (creado por users[1]) */);
        
        //Comprobar que los resultados son correctos
        assertEquals(4f, p1.getApoyos(), 1);

        //Dos personas apoyan el proyecto
        p1.apoyarProyecto(users[2]);
        p1.apoyarProyecto(users[3]);

        //Comprobar que ahora el numero de apoyos es 3
        assertEquals(4f, p1.getApoyos(), 3);
        
        //Una persona que ya lo habia apoyado apoya el proyecto de nuevo
        p1.apoyarProyecto(users[2]);

        //Comprobar que el numero de apoyos sigue siendo 3
        assertEquals(4f, p1.getApoyos(), 3);

        //Un colectivo apoya este proyecto
        Colectivo c1 = new Colectivo("c1", users[1]);
        c1.unirseAColectivo(users[0]);
        p1.apoyarProyecto(c1);

        //Comprobamos
        assertEquals(4f, p1.getApoyos(), 4);

        //un ciudadano bloqueado apoya el proyecto
        users[4].bloquearCiudadano();
        p1.apoyarProyecto(users[4]);

        //Comprobamos que no ha aumentado el numero de apoyos
        assertEquals(4f, p1.getApoyos(), 4);

        //Creamos un nuevo proyecto pero esta vez como colectivo, es decir, lo apoya un representante
        ProyectoSocial p2 = new ProyectoSocial(/* Argumentos (repre)*/);


        
    }
}