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
    
    public ProyectoSocial(String tit, int ident, Date fechCreacion, String desc, 
				  double presSolicitado, double presConcedido,
				  EstadoProyecto est, int votos, int votosMin, Date fechUltApoyo, 
                  String grupoSocial, TipoAlcance alcance) {
                super(tit,ident,fechCreacion,desc,presSolicitado,presConcedido,est,
                votos,votosMin,fechUltApoyo);
                this.grupoSocial = grupoSocial;
                this.alcance = alcance;
    }