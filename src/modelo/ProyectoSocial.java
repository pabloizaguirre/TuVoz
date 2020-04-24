package modelo;
import java.util.*;
import java.io.*;

/**
 * Subclase proyecto social.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class ProyectoSocial extends Proyecto {
    private String grupoSocial;
    private TipoAlcance alcance;
    
    public ProyectoSocial(String tit, String desc, double presSolicitado,
                            ElementoColectivo creador, String grupoSocial, TipoAlcance alcance){
                super(tit, desc, presSolicitado, creador, TipoProyecto.social);
                this.grupoSocial = grupoSocial;
                this.alcance = alcance;
    }
}