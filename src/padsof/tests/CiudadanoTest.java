package padsof.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import padsof.Ciudadano;

import org.junit.Before;
import java.util.*;

public class CiudadanoTest {

    
    //Falta: Comprobar que la lista de elementos que apoyan es correcta 
    @Test
    public void TestNifEnUso() {
        
        //Crear los objetos necesarios para la prueba
       Ciudadano c1=new Ciudadano(1234, usuario1,  76654993F, false);
       Ciudadano c2=new Ciudadano(1664, usuario1,  76654993F, false);
       Ciudadano c3=new Ciudadano(1984, usuario3,  73398440R, false);

        //Comprobar que los nif de c1 y c2 son iguales
        assertTrue(nifEnUso(c1.nif)==nifEnUso(c2.nif));

        //Comprobar que los nif de c1 y c3 son distintos
        assertTrue(nifEnUso(c1.nif)!=nifEnUso(c3.nif));       
    }


    //REVISAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public TestResgistrarUsusario{
        //Crear los objetos necesarios para la prueba
        Ciudadano c1=new Ciudadano(1434, usuario4,  78654993F, false);

        //Comprobamos ue el ciudadno creado y el registrado son el mismo?
        Ciudadano c2= registrarUsuario(1434, usuario4, 78654993F);
        assertSame(c1,c2);
    }

    @Test
    public TestBuscarCiudadano {
        //Crear los objetos necesarios para la prueba
        Ciudadano c=new Ciudadano(1434, usr,  78654999F, false);

        //Comprobar que el ciudadano devuelto por la función dado su nombre es igual a c
        assertSame(c, buscarCiudadano(usr));
        
    }    
    
    @Test
    public TestAnadirNotificacion{
        //Crear los objetos necesarios para la prueba
        Ciudadano c=new Ciudadano(14004, usr1,  78653499X, false);
        Notificacion n=new Notificacion(c, "Hola");

        //Comprobamos que se anade correctamente la notificacion al usuario
        assertTrue(c.anadirNotificacion(n)==true);   
    }    
    
    @Test
    public TestEliminarNotificacion{
        //Crear los objetos necesarios para la prueba
        Ciudadano c=new Ciudadano(14004, usr2,  78636499J, false);
        Notificacion n=new Notificacion(c, "Adios");
        c.anadirNotificacion(n);

        //Comprobamos que se elimina correctamente la notificacion al usuario
        assertTrue(c.eliminarNotificacion(n)==true);   
    }    

    @Test
    public TestAnadirAMisColectivos{
        //Crear los objetos necesarios para la prueba
        Ciudadano ciudadano1=new Ciudadano(14004, usr1,  78636499J, false);
        Ciudadano ciudadano2=new Ciudadano(14023, usr2,  78633349Q, false);
        Colectivo colec=new Colectivo("Voluntariado", ciudadano)

        //Comprobamos que se anade correctamente el colectivo a la lista de misColectivos
        assertTrue(anadirAMisColectivos(colec)==true);  
   
    }  
    
    @Test
    public TestEliminarDeMisColectivos{
        //Crear los objetos necesarios para la prueba
        Ciudadano ciudadano=new Ciudadano(14009, usr,  78636499T, false);
        Colectivo colec=new Colectivo("Voluntariado", ciudadano)
        anadirAMisColectivos(colec);

        //Comprobamos que se elimina correctamente el colectivo de la lista de misColectivos
        assertTrue(eliminarDeMisColectivos(colec)==true);   
    }  

    @Test
    public TestAnadirAMisProyectosApoyados{
        //Crear los objetos necesarios para la prueba
        Ciudadano ciudadano=new Ciudadano(14009, usr,  78636499T, false);
        Proyecto p= Proyecto("Voluntariado", ciudadano)
        anadirAMisColectivos(colec);

        //Comprobamos que se elimina correctamente el colectivo de la lista de misColectivos
        assertTrue(eliminarDeMisColectivos(colec)==true);   
    }  
    

}