package es.uc3m.tiw.dominios;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Grupo 3 TIW 2016
 *
 */
@Entity
@Table(name="USUARIOS")
public class Usuario {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(nullable = false, length = 15)
	private String nombre;
	@Column(length = 30)
	private String apellidos;
	@Column
	private String ciudad;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;

	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre, String apellidos, String ciudad,
			String password, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
