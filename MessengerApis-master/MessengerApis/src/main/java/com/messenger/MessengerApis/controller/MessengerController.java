package com.messenger.MessengerApis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.messenger.MessengerApis.Service.UserService;
import com.messenger.MessengerApis.dto.UserDTO;

@RestController
public class MessengerController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getUsuario(@PathVariable("id") long id)
	{
		
		logger.info("Busqueda de usaurio por ID {}", UserDTO.class);
		return userService.getUser(id);
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUsuario(@RequestBody UserDTO userDTO)
	{
		
		logger.info("Guardado de usaurio por {}", UserDTO.class);
		userService.saveUser(userDTO);
		
	}
	
	@GetMapping(value = "/")
	public String hola() 
	{
		return "hola mundo";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> getUsuario()
	{
		
		logger.info("Busqueda de usaurio por ID {}", UserDTO.class);
		return userService.getUsers();
	}
	
	
	
	
	

}
