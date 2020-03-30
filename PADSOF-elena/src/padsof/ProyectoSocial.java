package padsof;
import java.util.*;
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
                            Ciudadano creador, String grupoSocial, TipoAlcance alcance){
                super(tit, desc, presSolicitado, creador, ProjectKind.social);
                this.grupoSocial = grupoSocial;
                this.alcance = alcance;
    }
}