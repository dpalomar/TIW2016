package es.uc3m.tiw.dominios;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

import javax.persistence.Column;



@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	
	
	@Column(nullable = false, length = 16, name = "clave")
	protected String password;
	@Column(name = "email")
	protected String email;
	
   
    public Administrador() {
    }


	public Administrador(int id, String password, String email) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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