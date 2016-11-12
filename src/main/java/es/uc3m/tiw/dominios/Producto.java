package es.uc3m.tiw.dominios;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "PRODUCTOS")
public class Producto{
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	@Column
	protected String titulo;
	@Column
	protected String categoria;
	@Column ( length = 45)
	protected String descripcion;
	@Column
	protected String imagen;
	@Column
	protected String precio;
	@Column
	protected String estado = "Disponible"; /*Estado inicial al dar de alta producto*/
	
	//@ManyToOne(cascade = ALL)
	//protected Usuario usuario;
	
	public Producto() {
		
	}

	public Producto(int id, String titulo, String categoria, String descripcion,
			String estado, String precio, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.estado = estado;
		this.precio = precio;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
		

}
