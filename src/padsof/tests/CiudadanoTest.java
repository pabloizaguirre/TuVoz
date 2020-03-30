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
       Ciudadano c1 = new Ciudadano(1234, usuario1,  76654993F, false);
       Ciudadano c2 = new Ciudadano(1664, usuario2,  76654993F, false);
       Ciudadano c3 = new Ciudadano(1984, usuario3,  73398440R, false);

        //Comprobar que los nif de c1 y c2 son iguales
        assertTrue(nifEnUso(c1.nif)==nifEnUso(c2.nif));

        //Comprobar que los nif de c1 y c3 son distintos
        assertTrue(nifEnUso(c1.nif)!=nifEnUso(c3.nif));
    }


    //REVISAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public TestResgistrarUsusario{
        //Crear los objetos necesarios para la prueba
        Ciudadano c1 = new Ciudadano(1434, usuario4,  78654993F, false);

        //Comprobamos ue el ciudadno creado y el registrado son el mismo?
        Ciudadano c2 = registrarUsuario(1434, usuario4, 78654993F);
        assertSame(c1,c2);
    }

    @Test
    public TestBuscarCiudadano {
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(1434, usr,  78654999F, false);

        //Comprobar que el ciudadano devuelto por la función dado su nombre es igual a c
        assertSame(c, buscarCiudadano(usr));

    }

   

    @Test
    public TestAnadirAMisColectivos{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(14004, usr1,  78636499J, false);
        Colectivo colec = new Colectivo("Voluntariado", ciudadano);

        //Comprobamos que se anade correctamente el colectivo a la lista de misColectivos
        assertTrue(c.anadirAMisColectivos(colec));

    }

    @Test
    public TestEliminarDeMisColectivos{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(12234, Mamba, 36789543M, false);
        Ciudadano ciudadano = new Ciudadano(14009, usr,  78636499T, false);
        Colectivo colec = new Colectivo("Voluntariado", ciudadano);
        anadirAMisColectivos(colec);

        //Comprobamos que se elimina correctamente el colectivo de la lista de misColectivos
        assertTrue(c.eliminarDeMisColectivos(colec));
    }


    @Test
    public TestAnadirAMisProyectosSuscritos{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(12234, localHost, 66359889F, false);
        Ciudadano ciudadano = new Ciudadano(14009, usr,  78636499T, false);
        ProyectoSocial p = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, ciudadano, "jovenes", 0);

        //Comprobamos que se añade correctamente el proyecto de la lista de suscritos
        assertTrue(c.anadirAMisProyectosSuscritos(p));
    }

    @Test
    public TestInformePopularidad{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(12234, localHost, 66359889F, false);
        Ciudadano c1 = new Ciudadano(1214, usu1,  76651193F, false);
        Ciudadano c2 = new Ciudadano(1614, usu2,  76652293F, false);
        ProyectoSocial p = new ProyectoSocial("Centros Comerciales","Este es un proyecto que incentiva el consumo en centros comerciales", 200000, c, "jovenes", 0);
        Notificacion n = new Notificacion(c, "Informe de popularidad del proyecto " + p + " :\nNúmero de apoyos = " + "2");

        //Hacemos que dos ciudadanos apoyen al proyecto p
        p.apoyarProyecto(c1);
        p.apoyarProyecto(c2);

        //Comprobamos nos devuleve correctamnet los apoyos del proyecto
        assertSame(c.solicitarInformePopularidad(p),n);
    }

    @Test
    public TestInformeAfinidad{
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano(12234, localHost, 66359889F, false);
        Ciudadano ciudadano = new Ciudadano(12234, localHost, 66359889F, false);
        Colectivo c1 = new Colectivo("Voluntariado", ciudadano);
        Colectivo c2 = new Colectivo("Catequesis", ciudadano);
        ProyectoSocial p1 = new ProyectoSocial("prueba1","Este es un proyecto de prueba1", 200000, c1, "jovenes1", 0);
        ProyectoSocial p2 = new ProyectoSocial("prueba2","Este es un proyecto de prueba2", 200000, c2, "jovenes2", 0);
        ProyectoSocial p3 = new ProyectoSocial("prueba3","Este es un proyecto de prueba3", 200000, c2, "jovenes3", 0);
        Notificacion noti = new Notificacion(c, "Informe de afinidad de los colectivos " + c1 + " y " + c2 + " :\nÍndice de afinidad: " + "2/3");

        //Añadimos c1 y c2 a la lista de colectivos de c
        c.anadirAMisColectivos(c1);
        c.anadirAMisColectivos(c2);

        //Hacemos que c1 apoye un proyecto de c2 y viceversa
        p2.apoyarProyecto(c1);
        p1.apoyarProyecto(c2);

        //Comprobamos que se añade correctamente el proyecto de la lista de suscritos
        assertSame(c.solicitarInformeAfinidad(c1,c2), noti);
    }

}
