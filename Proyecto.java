import java.time.LocalDate;
import java.util.*;
import es.uam.eps.sadp.grants.*;

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
	private ProjectKind tipo;
	private LocalDate fechaCreacion;
	private String descripcion;
	private double presupuestoSolicitado;
	private double presupuestoConcedido;
	private EstadoProyecto estado;
	private boolean autorizado;
	private int apoyos;
	private LocalDate fechaUltimoApoyo;
	private Ciudadano creador;
	private List<ElementoColectivo> listadoApoyos;
	private List<Ciudadano> listadoSuscripciones;
	private String idEnvio;
		
	


	public Proyecto(String titulo, ProjectKind tipo, 
					String descripcion, double presupuestoSolicitado, 
					double presupuestoConcedido, int apoyos,Ciudadano creador) {
		
		this.titulo = titulo;
		//El id de cada proyecto será uno mayor que el del último proyecto creado
		this.id = ultimoIdAsignado;
		ultimoIdAsignado += 1;
		
		this.tipo = tipo;
		this.fechaCreacion = LocalDate.now() ;
		this.descripcion = descripcion;
		this.presupuestoSolicitado = presupuestoSolicitado;
		this.presupuestoConcedido = presupuestoConcedido;
		this.estado = EstadoProyecto.pendienteAprobacion;
		this.autorizado = false;
		this.apoyos = 0;
		this.fechaUltimoApoyo = LocalDate.now();
		this.creador = creador;
		this.listadoApoyos = new ArrayList<ElementoColectivo>();
		this.listadoSuscripciones = new ArrayList<Ciudadano>();
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
		public Ciudadano getCreador() { return creador; }
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
		public void setCreador(Ciudadano creador) { this.creador = creador;}
		public void setListadoApoyos(ArrayList<String> listadoApoyos) {this.listadoApoyos = listadoApoyos;}
		public void setListadoSuscripciones(ArrayList<String> listadoSuscripciones) {this.listadoSuscripciones = listadoSuscripciones;}
		public void setColectivosApoyantes(ArrayList<Colectivo> colectivosApoyantes) { this.colectivosApoyantes = colectivosApoyantes;}

			
		/* Falta saber como conseguir que todos los miembros del colectivo de un representante apoyen
		un proyecto a la vez */
		public boolean apoyarProyecto(ElementoColectivo e) {
			if(listadoApoyos.contains(e)) {
				return false;
			}

			//Si se vota como ciudadano

			if(e.getClass().equals(Ciudadano.class)) {
				listadoApoyos.add(e);
				(Ciudadano)e.anadirAMisProyectosApoyados(this);
				apoyos+=1;
				fechaUltimoApoyo = LocalDate.now();
			}

			//Si se vota como colectivo
			else if(e.getClass().equals(Colectivo.class)) //{
				/*if(usuarioActual.equals((Colectivo)e.getRepresentante())) {
					for(ElementoColectivo ele : (Colectivo)e.getElementos()){
						if(listaApoyos.contains(ele)==false) {
							listaApoyos.add(ele);
							if(ele.getClass().equals(Ciudadano.class)) {
								ele.anadirAMisProyectosApoyados(this);
								suscribirProyecto(ele);
								apoyos+=1;
								fechaUltimoApoyo = LocalDate.now();
							}
						}
					}

				}
			}
			*/
			
			
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
		

		void enviarProyecto() throws Exception {
			GrantRequest req = new SolicitudFinanciacion(this);
			CCGG proxy = CCGG.getGateway();
			String id = proxy.submitRequest(req);
			System.out.println("Valor:" + id);
			this.idEnvio=id
		}

		void consultar() throws Exception {
			CCGG proxy = CCGG.getGateway();
			presupuestoConcedido = proxy.getAmountGranted(this.idEnvio);
		}


		// Quedan por hacer metodos
		
		  
}