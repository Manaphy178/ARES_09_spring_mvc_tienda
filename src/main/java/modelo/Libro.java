package modelo;

import org.springframework.web.multipart.MultipartFile;

public class Libro {

	private String titulo;
	private String descripcion;
	private double precio;
	private MultipartFile portada;
	private long id;

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, String descripcion, double precio) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MultipartFile getPortada() {
		return portada;
	}

	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}

}
