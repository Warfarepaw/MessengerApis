package com.messenger.MessengerApis.dto;

import com.messenger.MessengerApis.Entity.UserEntity;

public class UserDTO {

	
	Long id;

	String nombre;

	String password;
	
	String correo;
	
	String confCode;
	
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

	public UserDTO(Long id, String nombre, String password, String correo) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
	}

	public UserDTO() {
		super();
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
	
	public static UserDTO valueOf(UserEntity userEntity) 
	{
		UserDTO user = new UserDTO();
		user.setCorreo(userEntity.getCorreo());
		user.setNombre(userEntity.getNombre());
		user.setId(userEntity.getId());
		user.setPassword(userEntity.getPassword());
		user.setConfStatus(userEntity.isConfStatus());
		user.setConfCode(userEntity.getConfCode());
		
		
		return user;
	}
	
	public UserEntity createEntity(UserDTO userDTO) 
	{
		UserEntity user = new UserEntity();
		
		user.setCorreo(userDTO.getCorreo());
		user.setId(userDTO.getId());
		user.setNombre(userDTO.getNombre());
		user.setPassword(userDTO.getPassword());
		user.setConfStatus(userDTO.isConfStatus());
		user.setConfCode(userDTO.getConfCode());
		return user;
		
	}
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nombre=" + nombre + ", password=" + password + ", correo=" + correo + "]";
	}


}
