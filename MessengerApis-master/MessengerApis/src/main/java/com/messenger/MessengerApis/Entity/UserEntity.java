package com.messenger.MessengerApis.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(nullable = false)
	String nombre;
	
	@Column(nullable = false)
	String password;
	
	@Column(nullable = false, unique = true)
	String correo;
	
	@Column(name = "confCode")
	String confCode;
	
	@Column(name = "confStatus")
	boolean confStatus;


	public String getConfCode() {
		return confCode;
	}

	public void setConfCode(String confCode) {
		this.confCode = confCode;
	}

	public boolean isConfStatus() {
		return confStatus;
	}

	public void setConfStatus(boolean confStatus) {
		this.confStatus = confStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
