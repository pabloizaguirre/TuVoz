import java.util.*;

/**
 * Clase Ciudadano. 
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Ciudadano extends Usuario {

    private String nif;
    private boolean bloqueado;

    //lista de colectivos de los que soy miembro
    Private ArrayList<Colectivo> misColectivos;
    //lista de colectivos de los que es representante
    Private ArrayList<Colectivo> colectivosCreados;
    Private ArrayList<Proyecto> proyectosCreados;
    Private ArrayList<Proyecto> proyectosApoyados;
    Private ArrayList<Proyecto> proyectosSuscritos;


    public Ciudadano(String contr, String nomUs, String nif, boolean bloq){
        super(nomUs, contr);
        this.nif = nif;
        this.bloqueado = bloq;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public ArrayList<Colectivo> getMisColectivos() {
        return this.misColectivos;
    }

    public void setMisColectivos(ArrayList<Colectivo> misColectivos) {
        this.misColectivos = misColectivos;
    }

    public ArrayList<Colectivo> getColectivosCreados() {
        return this.colectivosCreados;
    }

    public void setColectivosCreados(ArrayList<Colectivo> colectivosCreados) {
        this.colectivosCreados = colectivosCreados;
    }

    public ArrayList<Proyecto> getProyectosCreados() {
        return this.proyectosCreados;
    }

    public void setProyectosCreados(ArrayList<Proyecto> proyectosCreados) {
        this.proyectosCreados = proyectosCreados;
    }

    public ArrayList<Proyecto> getProyectosApoyados() {
        return this.proyectosApoyados;
    }

    public void setProyectosApoyados(ArrayList<Proyecto> proyectosApoyados) {
        this.proyectosApoyados = proyectosApoyados;
    }

    public ArrayList<Proyecto> getProyectosSuscritos() {
        return this.proyectosSuscritos;
    }

    public void setProyectosSuscritos(ArrayList<Proyecto> proyectosSuscritos) {
        this.proyectosSuscritos = proyectosSuscritos;
    }



    
    /**
     * Esta funcion solo debe ser llamada por unirseAColectivo,
     * no deberiamos llamar a esta funcion cuando queramos unirnos a un colectivo
     *s
     * @param c un ciudadano que se quiere unir al colectivo
     * @return false si el ciudadano ya es miembro de ese colectivo, true si el ciudadano ha sido añadido correctamente 
     * a la lista de misColectivos.
     */
    public boolean anadirAMisColectivos(Colectivo c){
        if(misColectivos.contains(c)){
            return false;
        }
        misColectivos.add(c);
        
        return true;
    }
    
    public boolean eliminarDeMisColectivos(Colectivo c){
        if(!misColectivos.contains(c)){
            return false;
        }
        misColectivos.remove(c);
        
        return true;
    }


    public boolean anadirAMisProyectosApoyados(Proyecto p){
        if(proyectosApoyados.contains(p)){
            return false;
        }
        proyectosApoyados.add(p);
        
        return true;
    }
    
     public boolean anadirAMisProyectosSuscritos(Proyecto p){
        if(proyectosSuscritos.contains(p)){
            return false;
        }
        proyectosSuscritos.add(p);
        
        return true;
    }



























    public double solicitarInformePopularidad(Proyecto p){
        if (proyectosCreados.contains(p)){
            return p.getApoyos;
        }

        else{retun -1;}
    }

    
}
    public double solicitarInformeAfinidad(Colectivo c1, Colectivo c2){
        int proyeC1=0;
        int proyeC2=0;
        int proyeC1apoyC2=0;
        int proyeC2apoyC1=0;

        if (misColectivos.conatins(c1) && misColectivos.contains(c2)){

            for (Proyectos p:c1.getProyectos()){
                proyeC1+=1;
                
                if(p.getcolectivosApoyantes().contains(c2)){
                    proyeC1apoyC2+=1;
                }
            }


            for (Proyectos p:c2.getProyectos()){
                proyeC2+=1;
                
                if(p.getColectivosApoyantes().contains(c2)){
                    proyeC2apoyC1+=1;
                }
            }
            

            return (proyeC1apoyC2 + proyeC2apoyC1)/(proyeC1 + proyeC2) ;
        }

        else return -1;
    }


  