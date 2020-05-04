package modelo;
import es.uam.eps.sadp.grants.*;
import java.time.LocalDate;
import java.util.*;
import java.io.*;



/**
 * Clase proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Proyecto implements Serializable {
	private String titulo;
	private int id;
	private LocalDate fechaCreacion;
	private String descripcion;
	private double presupuestoSolicitado;
	private Double presupuestoConcedido;
	private EstadoProyecto estado;
	private boolean autorizado;
	private int apoyos;
	private LocalDate fechaUltimoApoyo;
	private ElementoColectivo creador;
	private List<ElementoColectivo> listadoApoyos;
	private List<Ciudadano> listadoSuscripciones;
	private String idEnvio;
	
	private static final Integer NUM_INTENTOS = 3;
		
	


	public Proyecto(String titulo,
					String descripcion, double presupuestoSolicitado, ElementoColectivo creador) {
		
		this.titulo = titulo;
		//El id de cada proyecto será uno mayor que el del último proyecto creado
		this.id = Aplicacion.getAplicacion().getUltimoIdAsignado();
		Aplicacion.getAplicacion().setUltimoIdAsignado(this.id + 1);
		
		this.fechaCreacion = FechaSimulada.getHoy();
		this.descripcion = descripcion;
		this.presupuestoSolicitado = presupuestoSolicitado;
		this.estado = EstadoProyecto.PENDIENTECREACION;
		this.autorizado = false;
		this.apoyos = 0;
		this.fechaUltimoApoyo = FechaSimulada.getHoy();
		this.creador = creador;
		this.listadoApoyos = new ArrayList<ElementoColectivo>();
		this.listadoSuscripciones = new ArrayList<Ciudadano>();

		/**El creador apoya el proyecto y se añade a la lista de sus proyectos creados */
		apoyarProyecto(creador);

		/* El creador se suscribe al proyecto */
		if(creador.getClass().equals(Colectivo.class)){
			suscribirProyecto(((Colectivo) creador).getRepresentante());
		} else {
			suscribirProyecto((Ciudadano) creador);
		}

		/* El creador lo añade a su lista de proyectos propuesto */
		creador.anadirAMisProyectosPropuestos(this);

		/**El proyecto se añade a la lista de proyectos de la aplicacion */
		Aplicacion.getAplicacion().anadirProyecto(this);
		new NotificacionProyectoNuevo(this, Aplicacion.getAplicacion().getAdministrador());
	}
	
	
	
		
		public String getTitulo() { return titulo; }
		public int getId() { return id; }
		public LocalDate getFechaCreacion() { return fechaCreacion; }
		public String getDescripcion()  { return descripcion; }
		public double getPresupuestoSolicitado() { return presupuestoSolicitado;}
		public Double getPresupuestoConcedido() { return presupuestoConcedido;}
		public boolean getAutorizado() { return autorizado;}
		public int getApoyos() { return apoyos;}
		public LocalDate getFechaUltimoApoyo() { return fechaUltimoApoyo;}
		public ElementoColectivo getCreador() { return creador; }
		public List<ElementoColectivo> getListadoApoyos() { return listadoApoyos;}
		public List<Ciudadano> getListadoSuscripciones() { return listadoSuscripciones;}

	
		
		
		public void setTitulo(String titulo) { this.titulo = titulo; }
		public void setId(int identificador) { this.id = identificador;}
		public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion;}
		public void setDescripcion(String descripcion) { this.descripcion = descripcion;}
		public void setPresupuestoSolicitado(double presupuestoSolicitado) { this.presupuestoSolicitado = presupuestoSolicitado;}
		public void setPresupuestoConcedido(Double presupuestoConcedido) { this.presupuestoConcedido = presupuestoConcedido;}
		public void setAutorizado(boolean autorizado) { this.autorizado = autorizado;}
		public void setApoyos(int apoyos) { this.apoyos = apoyos;}
		public void setFechaUltimoApoyo(LocalDate fechaUltimoApoyo) { this.fechaUltimoApoyo = fechaUltimoApoyo; }
		public void setCreador(ElementoColectivo creador) { this.creador = creador;}
		public void setListadoApoyos(ArrayList<ElementoColectivo> listadoApoyos) {this.listadoApoyos = listadoApoyos;}
		public void setListadoSuscripciones(List<Ciudadano> listadoSuscripciones) {this.listadoSuscripciones = listadoSuscripciones;}
	
	

		/**
		 * Método para cambiar el estado de un proyecto. Se
		 * El metodo envia una notificacion a cada ciudadano suscrito al proyecto
		 * 
		 * @param e EstadoProyecto al que queremos actualizar el proyecto.
		 */	
		private void cambiarEstado(EstadoProyecto e){
			if(e.equals(EstadoProyecto.RECHAZADO)){
				Aplicacion.getAplicacion().eliminarProyecto(this);
			}
			this.estado = e;
			
			for(Ciudadano c:listadoSuscripciones){
				new NotificacionProyectoEstado(this,c);
			}
		}
		
		/**
		 * Metodo al que se debe llamar cuando el administrador aprueba un proyecto
		 */
		public void aprobarProyecto() {
			if(Aplicacion.getAplicacion().getUsuarioActual().equals(Aplicacion.getAplicacion().getAdministrador()) && this.estado.equals(EstadoProyecto.PENDIENTECREACION)) {
				cambiarEstado(EstadoProyecto.NOENVIADO);
			}
		}
		
		/**
		 * Metodo al que se debe llamar cuando el administrador rechaza un proyecto
		 * 
		 * @param mensaje con el motivo del rechazo
		 */
		public void rechazarProyecto(String mensaje) {
			if(Aplicacion.getAplicacion().getUsuarioActual().equals(Aplicacion.getAplicacion().getAdministrador()) && this.estado.equals(EstadoProyecto.PENDIENTECREACION)) {
				cambiarEstado(EstadoProyecto.RECHAZADO);
			}
			for(Ciudadano c:listadoSuscripciones){
				new NotificacionProyectoEstado(this,c,mensaje);
			}
		}

		/**
		 * Método para apoyar un proyecto 
		 * 
		 * @param e ElementoColectivo que va a apoyar el proyecto
		 * 
		 * @return boolean true si se ha apoyado con exito, false en caso contrario
		 */
		public boolean apoyarProyecto(ElementoColectivo e) {
			if(listadoApoyos.contains(e) || this.estado.equals(EstadoProyecto.CADUCADO)
				|| this.estado.equals(EstadoProyecto.FINANCIADO)) {
				return false;
			}
			
			listadoApoyos.add(e);
			e.anadirAMisProyectosApoyados(this);

			//Si se vota como ciudadano
			if(e.getClass().equals(Ciudadano.class)) {
				apoyos+=1;
				if(apoyos >= Aplicacion.getAplicacion().getApoyosMin() && (estado.equals(EstadoProyecto.NOENVIADO) || estado.equals(EstadoProyecto.CADUCADO))){
					cambiarEstado(EstadoProyecto.DISPONIBLE);;
				}
				fechaUltimoApoyo = FechaSimulada.getHoy();
				return true;
			}

			//Si se vota como colectivo
			apoyarProyectoIndirectamente((Colectivo) e);
			return true;
		}

		/**
		 * Método que permite a los miembros de un colectivo y sus respectivos subcolectivos apoyar un proyecto sin
		 * que el colectivo pasado como argumento sea incluido en la lista de apoyos
		 * 
		 * @param c colectivo que indirectamente apoya el proyecto
		 */
		private void apoyarProyectoIndirectamente(Colectivo c){
			for(ElementoColectivo ele : c.getElementos()){
				if(listadoApoyos.contains(ele)==false) {
					if(ele.getClass().equals(Colectivo.class)){
						apoyarProyectoIndirectamente(((Colectivo) ele));
					} else {
						listadoApoyos.add(ele);
						((Ciudadano) ele).anadirAMisProyectosApoyados(this);
						apoyos+=1;
						if(apoyos >= Aplicacion.getAplicacion().getApoyosMin()){
							cambiarEstado(EstadoProyecto.DISPONIBLE);;
						}
						fechaUltimoApoyo = FechaSimulada.getHoy();
					}
				}
			}
			return;
		}



		/**
		 * Método para eliminar el apoyo a un proyecto 
		 * 
		 * @param ciu Ciudadano que elimina su apoyo
		 * 
		 * 
		 */
			public void eliminarApoyo(Ciudadano ciu) {
				if(listadoApoyos.contains(ciu)) {
					listadoApoyos.remove(ciu);
					apoyos-=1;
				}
			}
		
		
		/**
		 * Este metodo suscribe a un ciudadano a este proyecto.Llamar a este metodo y no a anadirAMisProyectosSuscritos.
		 * 
		 * @param ciu ciudadano suscriptor
		 * 
		 * @return false si ya esta suscrito
		 */
		public boolean suscribirProyecto(Ciudadano ciu) {
			if(listadoSuscripciones.contains(ciu)) {
				return false;
			}
			listadoSuscripciones.add(ciu);
			
			return true;
		}


		/**
		 * Este metodo devuelve el estado de un proyecto, además de comprobar si 
		 * se cumplen los requisitos del estado disponible y caducado
		 * 
		 * 
		 * @return EstadoProyecto
		 */
		public EstadoProyecto consultarEstadoProyecto(){
			if(estado.equals(EstadoProyecto.NOENVIADO) && fechaUltimoApoyo.isBefore(FechaSimulada.getHoy().minusDays(30))){
				this.cambiarEstado(EstadoProyecto.CADUCADO);
			} 
			if((estado.equals(EstadoProyecto.NOENVIADO) || estado.equals(EstadoProyecto.CADUCADO)) && apoyos >= Aplicacion.getAplicacion().getApoyosMin()) {
				this.cambiarEstado(EstadoProyecto.DISPONIBLE);
			}
			if(estado.equals(EstadoProyecto.PENDIENTEFINANCIACION)) {
				try {
					CCGG proxy = CCGG.getGateway();
					proxy.setDate(FechaSimulada.getHoy());
					consultar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return estado;
		}
		
		/**
		 * Método que envía un proyecto al sistema externo para la financiacion, si surge la excepcion
		 * IOException, vuelve a intentarlo 2 veces mas
		 * 
		 */
		public void enviarProyecto() throws Exception {
			if(this.consultarEstadoProyecto().equals(EstadoProyecto.DISPONIBLE) || (this.consultarEstadoProyecto().equals(EstadoProyecto.CADUCADO) && apoyos >= Aplicacion.getAplicacion().getApoyosMin())) {
				GrantRequest req = new SolicitudFinanciacion(this);
				int i = 0;
				while(i < NUM_INTENTOS) {
					i+=1;
					try {
						CCGG proxy = CCGG.getGateway();
						String requestId = proxy.submitRequest(req);
						this.idEnvio=requestId;
						this.cambiarEstado(EstadoProyecto.PENDIENTEFINANCIACION);
					} catch (IOException e) {
						if(i==NUM_INTENTOS) {
							e.printStackTrace();
						}
						continue;
					}
					break;
				}
			}
		}




		/**
		 * Método que consulta el estado de un proyecto enviado a financiación, si surge la excepcion
		 * IOException, vuelve a intentarlo 2 veces mas
		 * 
		 */
		void consultar() throws Exception {
			int i = 0;
			while(i < NUM_INTENTOS) {
				i+=1;
				try {
					CCGG proxy = CCGG.getGateway();
					presupuestoConcedido = proxy.getAmountGranted(this.idEnvio);
					if(presupuestoConcedido==null) {
						return;
					}else if(presupuestoConcedido > 0) {
						cambiarEstado(EstadoProyecto.FINANCIADO);
					} else {
						cambiarEstado(EstadoProyecto.RECHAZADO);
					}
				} catch (IOException e) {
					if(i==NUM_INTENTOS) {
						e.printStackTrace();
					}
					continue;
				}
				break;
			}
		} 

		/**
		 * Este metodo permite buscar un proyecto entre los disponibles
		 * 
		 * @param s String del titulo del proyecto
		 * 
		 * @return Proyecto requerido, null si no existe
		 */
		
		public static Proyecto buscarProyecto(String s) {
			for(Proyecto p : Aplicacion.getAplicacion().getListadoProyectos()) {
				if(p.getTitulo().equals(s)) {
					return p;
				}
			}return null;
		}

		
		public String toString(){
			return "" + this.titulo + ", id: " + this.id;
		}
		
		  
}