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
	private double presupuestoSolicitado;
	private double presupuestoConcedido;
	private EstadoProyecto estado;
	private boolean autorizado;
	private int apoyos;
	private int apoyosMin;
	private Date fechaUltimoApoyo;
	private Ciudadano creador;
	private ArrayList<Ciudadano> listadoApoyos;
	private ArrayList<Ciudadano> listadoSuscripciones;
	private ArrayList<Colectivo> colectivosApoyantes;
		
	public Proyecto(String tit, int ident, Date fechCreacion, String desc, 
					double presSolicitado, double presConcedido,
					EstadoProyecto est, int votos, int votosMin, Date fechUltApoyo) {
			titulo = tit; id = ident; 
			fechaCreacion = fechCreacion; descripcion = desc;
			presupuestoSolicitado = presSolicitado; presupuestoConcedido = presConcedido;
			estado = est; apoyos = votos; apoyosMin = votosMin; fechaUltimoApoyo = fechUltApoyo; 
			this.listadoApoyos = new ArrayList<Ciudadano>();
			this.listadoSuscripciones = new ArrayList<Ciudadano>();
			this.colectivosApoyantes = new ArrayList<Colectivo>();
		}
		
		public String getTitulo() { return titulo; }
		public int getId() { return id; }
		public Date getFechaCreacion() { return fechaCreacion; }
		public String getDescripcion()  { return descripcion; }
		public double getPresupuestoSolicitado() { return presupuestoSolicitado;}
		public double getPresupuestoConcedido() { return presupuestoConcedido;}
		public EstadoProyecto getEstadoProyecto() { return estado;}
		public boolean getAutorizado() { return autorizado;}
		public int getApoyos() { return apoyos;}
		public int getApoyosMin() { return apoyosMin;}
		public Date getFechaUltimoApoyo() { return fechaUltimoApoyo;}
		public Ciudadano getCreador() { return creador; }
		public ArrayList<Ciudadano> getListadoApoyos() { return listadoApoyos;}
		public ArrayList<Ciudadano> getListadoSuscripciones() { return listadoSuscripciones;}
		public ArrayList<Colectivo> getColectivosApoyantes() { return colectivosApoyantes;}
		//faltan getters y setters
		
		public void setTitulo(String titulo) { this.titulo = titulo; }
		public void setId(int identificador) { this.id = identificador;}
		public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion;}
		public void setDescripcion(String descripcion) { this.descripcion = descripcion;}
		public void setPresupuestoSolicitado(int presupuestoSolicitado) { this.presupuestoSolicitado = presupuestoSolicitado;}
		public void setPresupuestoConcedido(int presupuestoConcedido) { this.presupuestoConcedido = presupuestoConcedido;}
		public void setEstadoProyecto(EstadoProyecto estado) { this.estado = estado;}
		public void setAutorizado(boolean autorizado) { this.autorizado = autorizado;}
		public void setApoyos(int apoyos) { this.apoyos = apoyos;}
		public void setApoyosMin(int apoyosMin) {this.apoyosMin = apoyosMin;}
		public void setFechaUltimoApoyo(Date fechaUltimoApoyo) { this.fechaUltimoApoyo = fechaUltimoApoyo; }
		public void setCreador(Ciudadano creador) { this.creador = creador;}
		public void setListadoApoyos(ArrayList<String> listadoApoyos) {this.listadoApoyos = listadoApoyos;}
		public void setListadoSuscripciones(ArrayList<String> listadoSuscripciones) {this.listadoSuscripciones = listadoSuscripciones;}
		public void setColectivosApoyantes(ArrayList<Colectivo> colectivosApoyantes) { this.colectivosApoyantes = colectivosApoyantes;}

			
		/* Falta saber como conseguir que todos los miembros del colectivo de un representante apoyen
		un proyecto a la vez */
		public boolean apoyarProyecto(Ciudadano ciu) {
			/*Control de errores para comprobar si el ciudadano ya ha apoyado el proyecto */
			if(listadoApoyos.contains(ciu)) {
				return false;
			}
			if(ciu.getProyectosApoyados().contains(this)) {
				return false;
			}
			/*Si el ciudadano no es el representante de ningun colectivo, se realiza un apoyo individual */
			if(ciu.getColectivosCreados().isEmpty()) {
				
				listadoApoyos.add(ciu);

				ciu.anadirAMisProyectosApoyados(this);		  
				apoyos++;
	
				return true;
			}
			/*Si el ciudadano es representante de un colectivo, se realiza el apoyo de todos los miembros de dicho
			colectivo, comprobando previamente si alguno de los miembros ya había votado el proyecto */
			else {
				for (Colectivo c:ciu.getColectivosCreados()){
					for(Ciudadano p: c.getElementos()) {
						if()

					}
				}
			}
			


			
			
			}
		
		public boolean suscribirProyecto(Ciudadano ciu) {
			if(listadoSuscripciones.contains(ciu)) {
				return false;
			}
			if(ciu.getProyectosSuscritos().contains(this)){
				return false;
			}
			listadoSuscripciones.add(ciu);
			
			return true;
		}
		


		// Quedan por hacer metodos
		
		  
}