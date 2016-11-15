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

	@Column (nullable = false)
	protected String titulo;
	@Column (nullable = false)
	protected String categoria;
	//La descripción no puede tener más de 500 caracteres
	@Column ( length = 500)
	protected String descripcion;
	//@Column
	//@Lob
	/*protected String imagen;*/
	@Column (nullable = false)
	protected String precio;
	@Column
	protected String estado;
	@Column
	protected int usuario;
	
	/*@ManyToOne(cascade = ALL)
	protected Usuario usuario;*/
	
	public Producto() {
		
	}

	public Producto(int id, String titulo, String categoria, String descripcion,
			String estado, String precio, int usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		//this.imagen = imagen;
		this.estado = estado;
		this.precio = precio;
		this.usuario = usuario;
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

	/*public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
*/
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
	

	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
        }
	}
		
