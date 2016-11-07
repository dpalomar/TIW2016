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
	
	public Producto(Long id, String tituloProducto, String categoriaProducto, String descripcion, String imagenProducto,
			String estadoProducto, Precio precioProducto) {
		super();
		this.id = id;
		this.tituloProducto = tituloProducto;
		this.categoriaProducto = categoriaProducto;
		this.descripcion = descripcion;
		this.imagenProducto = imagenProducto;
		this.estadoProducto = estadoProducto;
		this.precioProducto = precioProducto;
	}

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	
	@Column
	protected String tituloProducto;
	@Column(nullable = false, length = 10, name = "clave")
	protected String categoriaProducto;
	@Column ( length = 45)
	protected String descripcion;
	@Column
	protected String imagenProducto;
	@Column
	protected String estadoProducto = "Disponible"; /*Estado inicial al dar de alta producto*/
	
	@OneToOne(cascade = ALL)
	private Precio precioProducto;

	public Producto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloProducto() {
		return tituloProducto;
	}

	public void setTituloProducto(String tituloProducto) {
		this.tituloProducto = tituloProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public String getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public Precio getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Precio precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	

}
