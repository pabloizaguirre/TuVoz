/* import grants.*; */
import java.time.LocalDate;
import java.util.*;


/**
 * Clase proyecto.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */

public class Proyecto {
	private String titulo;
	private int id;
	private static int ultimoIdAsignado = 0;
	private LocalDate fechaCreacion;
	private String descripcion;
	private double presupuestoSolicitado;
	private double presupuestoConcedido;
	private EstadoProyecto estado;
	private boolean disponible;
	private boolean autorizado;
	private int apoyos;
	private LocalDate fechaUltimoApoyo;
	private ElementoColectivo creador;
	private List<ElementoColectivo> listadoApoyos;
	private List<Ciudadano> listadoSuscripciones;
	private String idEnvio;
	private ProjectKind tipo;
		
	


	public Proyecto(String titulo,
					String descripcion, double presupuestoSolicitado, ElementoColectivo creador, ProjectKind tipo) {
		
		this.titulo = titulo;
		//El id de cada proyecto será uno mayor que el del último proyecto creado
		this.id = ultimoIdAsignado;
		ultimoIdAsignado += 1;
		
		this.fechaCreacion = LocalDate.now() ;
		this.descripcion = descripcion;
		this.presupuestoSolicitado = presupuestoSolicitado;
		this.tipo = tipo;
		this.estado = EstadoProyecto.pendienteAprobacion;
		this.disponible = false;
		this.autorizado = false;
		this.apoyos = 0;
		this.fechaUltimoApoyo = LocalDate.now();
		this.creador = creador;
		apoyarProyecto(creador);
		/* Falta añadir a mis proyectos creados */
		
		this.listadoApoyos = new ArrayList<ElementoColectivo>();
		this.listadoSuscripciones = new ArrayList<Ciudadano>();
		Aplicacion.getAplicacion().anadirProyecto(this);
	}
	
	
	
		
		public String getTitulo() { return titulo; }
		public int getId() { return id; }
		public LocalDate getFechaCreacion() { return fechaCreacion; }
		public String getDescripcion()  { return descripcion; }
		public double getPresupuestoSolicitado() { return presupuestoSolicitado;}
		public double getPresupuestoConcedido() { return presupuestoConcedido;}
		public EstadoProyecto getEstadoProyecto() { return estado;}
		public boolean getAutorizado() { return autorizado;}
		public int getApoyos() { return apoyos;}
		public LocalDate getFechaUltimoApoyo() { return fechaUltimoApoyo;}
		public ElementoColectivo getCreador() { return creador; }
		public List<ElementoColectivo> getListadoApoyos() { return listadoApoyos;}
		public List<Ciudadano> getListadoSuscripciones() { return listadoSuscripciones;}
		
		//faltan getters y setters
		
		public void setTitulo(String titulo) { this.titulo = titulo; }
		public void setId(int identificador) { this.id = identificador;}
		public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion;}
		public void setDescripcion(String descripcion) { this.descripcion = descripcion;}
		public void setPresupuestoSolicitado(int presupuestoSolicitado) { this.presupuestoSolicitado = presupuestoSolicitado;}
		public void setPresupuestoConcedido(int presupuestoConcedido) { this.presupuestoConcedido = presupuestoConcedido;}
		public void setEstadoProyecto(EstadoProyecto estado) { this.estado = estado;}
		public void setAutorizado(boolean autorizado) { this.autorizado = autorizado;}
		public void setApoyos(int apoyos) { this.apoyos = apoyos;}
		public void setFechaUltimoApoyo(LocalDate fechaUltimoApoyo) { this.fechaUltimoApoyo = fechaUltimoApoyo; }
		public void setCreador(ElementoColectivo creador) { this.creador = creador;}
		public void setListadoApoyos(ArrayList<ElementoColectivo> listadoApoyos) {this.listadoApoyos = listadoApoyos;}
		public void setListadoSuscripciones(List<Ciudadano> listadoSuscripciones) {this.listadoSuscripciones = listadoSuscripciones;}

			
		
		public boolean apoyarProyecto(ElementoColectivo e) {

			/* Falta: que pasa si el ciudadano ya ha apoyado como colectivo? Se le esta metiendo
			otra vez de forma individual*/
			if(listadoApoyos.contains(e)) {
				return false;
			}

			//Si se vota como ciudadano
			if(e.getClass().equals(Ciudadano.class)) {
				listadoApoyos.add(e);
				((Ciudadano) e).anadirAMisProyectosApoyados(this);
				apoyos+=1;
				/* Me parece que esto se arregla cuando hagamos Aplicacion Singleton */
				if(apoyos >= Aplicacion.getAplicacion().getApoyosMin()){
					disponible = true;
				}
				fechaUltimoApoyo = LocalDate.now();
			}

			//Si se vota como colectivo
			else if(e.getClass().equals(Colectivo.class)) {
				listadoApoyos.add(e);
				if(Aplicacion.usuarioActual.equals(((Colectivo) e).getRepresentante())) {
					for(ElementoColectivo ele : ((Colectivo) e).getElementos()){
						if(listadoApoyos.contains(ele)==false && ele.getClass().equals(Ciudadano.class)) {
							listadoApoyos.add(ele);
							((Ciudadano) ele).anadirAMisProyectosApoyados(this);
							apoyos+=1;
							if(apoyos >= Aplicacion.getAplicacion().getApoyosMin()){
								disponible = true;
							}
							fechaUltimoApoyo = LocalDate.now();
						}
					}
				}
			}
			return true;
			}
		
		public void eliminarApoyo(Ciudadano ciu) {
			if(listadoApoyos.contains(ciu)) {
				listadoApoyos.remove(ciu);
				apoyos-=1;
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
		

		/* void enviarProyecto() throws Exception {
			GrantRequest req = new SolicitudFinanciacion(this);
			CCGG proxy = CCGG.getGateway();
			String id = proxy.submitRequest(req);
			System.out.println("Valor:" + id);
			this.idEnvio=id
		}

		void consultar() throws Exception {
			CCGG proxy = CCGG.getGateway();
			presupuestoConcedido = proxy.getAmountGranted(this.idEnvio);
		} */


		// Quedan por hacer metodos
		
		  
}