package org.upiita.spring.jdbc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// Mapea  la clase usuario con la tabla usuario
@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name="usuario_id")
	private Integer uusarioId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nombre")
	private String nombre;
	
	public String toString(){
		String representacion = "Nombre: " + this.getNombre() + ", " +
				                "E-mail: "    + this.getEmail() + ", " +
	                            "UsuarioId: "    + this.getUusarioId() + ", " + 
				                "Password: " + this.getPassword(); 
		return representacion;
	}
	
	public Integer getUusarioId() {
		return uusarioId;
	}

	public void setUusarioId(Integer uusarioId) {
		this.uusarioId = uusarioId;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
