package padsof.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import padsof.*;

public class CiudadanoTest {

    @Test
    public void TestNifEnUso() {

        //Crear los objetos necesarios para la prueba
        Ciudadano c1 = Ciudadano.registrarCiudadano("8383", "Miguel", "7439837474G");
      
        //Comprobamos si los nifs estan en uso
        assertTrue(Ciudadano.nifEnUso(c1.getNif()));
        assertFalse(Ciudadano.nifEnUso("545463773J"));

    }



    @Test
    public void TestBuscarCiudadano() {
        //Crear los objetos necesarios para la prueba
        Ciudadano c = Ciudadano.registrarCiudadano("1434", "123asd",  "1231312A");
        Ciudadano caux = Ciudadano.registrarCiudadano("14774", "asdadsx",  "12321313D");

        assertFalse(c==null);
        assertFalse(caux==null);
    
        //Comprobar que el ciudadano devuelto por la función dado su nombre es igual a c
        assertSame(c, caux.buscarCiudadano("usr"));;

    }

   

    @Test
    public void TestAnadirAMisColectivos() {
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("14004", "usr1",  "78636499J");
        Colectivo colec = new Colectivo("Voluntariado", c);

        //Comprobamos que se anade correctamente el colectivo a la lista de misColectivos
        assertTrue(c.anadirAMisColectivos(colec));

    }

    @Test
    public void TestEliminarDeMisColectivos() {
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("12234", "Mamba", "36789543M");
        Ciudadano ciudadano = new Ciudadano("14009", "usr",  "78636499T");
        Colectivo colec = new Colectivo("Voluntariado", ciudadano);
        c.anadirAMisColectivos(colec);

        //Comprobamos que se elimina correctamente el colectivo de la lista de misColectivos
        assertTrue(c.eliminarDeMisColectivos(colec));
    }


    @Test
    public void TestAnadirAMisProyectosSuscritos(){
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("12234", "localHost", "66359889F");
        Ciudadano ciudadano = new Ciudadano("14009", "usr",  "78636499T");
        ProyectoSocial p = new ProyectoSocial("Voluntariado","Este es un proyecto de voluntariado", 5000, ciudadano, "jovenes", TipoAlcance.nacional);

        //Comprobamos que se añade correctamente el proyecto de la lista de suscritos
        assertTrue(c.anadirAMisProyectosSuscritos(p));
    }

    @Test
    public void TestInformePopularidad() {
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("12234", "localHost", "66359889K");
        Ciudadano c1 = new Ciudadano("1214", "usu1",  "76651193F");
        Ciudadano c2 = new Ciudadano("1614", "usu2",  "76652293F");
        ProyectoSocial p = new ProyectoSocial("Centros Comerciales","Este es un proyecto que incentiva el consumo en centros comerciales", 200000, c, "jovenes", TipoAlcance.nacional);
        Notificacion n = new Notificacion("Informe de popularidad del proyecto " + p + " :\nNúmero de apoyos = " + "2", c);

        //Hacemos que dos ciudadanos apoyen al proyecto p
        p.apoyarProyecto(c1);
        p.apoyarProyecto(c2);

        //Comprobamos nos devuleve correctamnet los apoyos del proyecto
        assertSame(c.solicitarInformePopularidad(p),n);
    }

    @Test
    public void TestInformeAfinidad(){
        //Crear los objetos necesarios para la prueba
        Ciudadano c = new Ciudadano("12234", "localHost", "66359889F");
        Ciudadano ciudadano = new Ciudadano("12234", "localHost", "66359889F");
        Colectivo c1 = new Colectivo("Voluntariado", ciudadano);
        Colectivo c2 = new Colectivo("Catequesis", ciudadano);
        ProyectoSocial p1 = new ProyectoSocial("prueba1","Este es un proyecto de prueba1", 200000, c1, "jovenes1", TipoAlcance.nacional);
        ProyectoSocial p2 = new ProyectoSocial("prueba2","Este es un proyecto de prueba2", 200000, c2, "jovenes2", TipoAlcance.nacional);
        ProyectoSocial p3 = new ProyectoSocial("prueba3","Este es un proyecto de prueba3", 200000, c2, "jovenes3", TipoAlcance.nacional);
        Notificacion noti = new Notificacion("Informe de afinidad de los colectivos " + c1 + " y " + c2 + " :\nÍndice de afinidad: " + "2/3", c);

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
