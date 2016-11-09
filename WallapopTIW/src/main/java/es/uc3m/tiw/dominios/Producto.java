package es.uc3m.tiw.dominios;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	
	public Producto(int id, String tituloProducto, String categoriaProducto, String descripcion, String imagenProducto,
			String estadoProducto, Precio precioProducto) {
		super();
		this.id = id;
		this.titulo = tituloProducto;
		this.categoria = categoriaProducto;
		this.descripcion = descripcion;
		this.imagen = imagenProducto;
		this.estado = estadoProducto;
		this.precio = precioProducto;
	}

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	
	@Column
	protected String titulo;
	@Column(nullable = false, length = 10, name = "clave")
	protected String categoria;
	@Column ( length = 45)
	protected String descripcion;
	@Column
	protected String imagen;
	@Column
	protected String estado = "Disponible"; /*Estado inicial al dar de alta producto*/
	
	@OneToOne(cascade = ALL)
	private Precio precio;

	public Producto() {
		
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}


	

}
