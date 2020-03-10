import java.util.*;

/**
 * Clase proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public  class Proyecto {
	private String titulo;
	private int id;
	private Date fechaCreacion;
	private String descripcion;
	private Ciudadano creador;
	private double presupuestoSolicitado;
	private double presupuestoConcedido;
	private EstadoProyecto estado;
	private int apoyos;
	private int apoyosMin;
	private Date fechaUltimoApoyo;
	private ArrayList<String> listadoApoyos;
	private ArrayList<String> listadoSuscripciones;
	private ArrayList<Colectivos> colectivosApoyantes;
		
	public Proyecto(String tit, int ident, Date fechCreacion, String desc, 
					double presSolicitado, double presConcedido,
					EstadoProyecto est, int votos, int votosMin, Date fechUltApoyo) {
			this.listadoApoyos = new ArrayList();titulo = tit; id = ident; 
			fechaCreacion = fechCreacion; descripcion = desc;
			presupuestoSolicitado = presSolicitado; presupuestoConcedido = presConcedido;
			estado = est; apoyos = votos; apoyosMin = votosMin; fechaUltimoApoyo = fechUltApoyo; 
		}
		
		public long getTitulo() { return titulo; }
		public int getId() { return id; }
		public int getCreador() { return creador; }
		public Date getFechaCreacion() { return fechaCreacion; }
		public String getDescripcion()  { return descripcion; }
		public double getPresupuestoSolicitado() { return presupuestoSolicitado;}
		public double getPresupuestoConcedido() { return presupuestoConcedido;}
		public EstadoProyecto getEstadoProyecto() { return estado;}
		public int getApoyos() { return apoyos;}
		public int getApoyosMin() { return apoyosMin;}
		public Date getFechaUltimoApoyo() { return fechaUltimoApoyo;}

		//faltan getters y setters
		
		public void setTitulo(String tit) { titulo = tit; }
		public void setId(int identificador) { id = identificador;}
		public void setCreador(Ciudadano ciu) { creador = ciu;}
		public void setFechaCreacion(Date fecha) { fechaCreacion = fechCreacion;}
		public void setDescripcion(String desc) { descripcion = desc;}
		public void setPresupuestoSolicitado(int pres) { presupuestoSolicitado = pres;}
		public void setPresupuestoConcedido(int pres) { presupuestoConcedido = pres;}
		public void setEstadoProyecto(EstadoProyecto est) { estado = est;}
		public void setApoyos(int votos) { apoyos = votos;}
		public void setApoyosMin(int votosMin) {apoyosMin = votosMin;}
		public void setFechaUltimoApoyo(Date fecha) { fechaUltimoApoyo = fecha; }

			
		public boolean apoyarProyecto(Ciudadano ciu) {
			if(listadoApoyos.contais(ciu.getNombreUsuario())) {
				return false;
			}

			for (Colectivo c:ciu.getColectivosCreados()){
				//falta terminar esta funcion y que todos los ciudadanos de los
				//colectivos creados por el ciudadano apoyen el proyecto
			}


			if(ciu.getProyectosApoyados().contais(this)) {
				return false;
			}
			listadoApoyos.add(ciu.getNombreUsuario());

			ciu.anadirAMisProyectosApoyados(this);		  
			apoyos++;

			return true;
			}
		
		public boolean suscribirProyecto(Ciudadano ciu) {
			if(listadoSuscripciones.contains(ciu.getNombreUsuario())) {
				return false;
			}
			if(ciu.getProyectosSuscritos().contains(this)){
				return false;
			}
			listadoSuscripciones.add(ciu.getNombreUsuario());
			
			return true;
		}
		


		// Quedan por hacer metodos
		
		  
}