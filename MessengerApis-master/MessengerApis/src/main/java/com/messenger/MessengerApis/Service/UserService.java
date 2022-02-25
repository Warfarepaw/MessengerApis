package com.messenger.MessengerApis.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.messenger.MessengerApis.Entity.Mail;
import com.messenger.MessengerApis.Entity.UserEntity;
import com.messenger.MessengerApis.Repository.CallUserRepository;
import com.messenger.MessengerApis.dto.UserDTO;


@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CallUserRepository userRepo;
	
	@Autowired
	MailService mailService;
	
	public UserDTO getUser(@PathVariable long id) 
	{
		
		logger.info("Request para el id del usuario");
		
		UserDTO userDTO = new UserDTO();
		userDTO = userDTO.valueOf(userRepo.getById(id)) ;
		return userDTO;
	}
	
	public boolean saveUser(UserDTO userDTO) 
	{
		
		
		UserDTO DBuserDTO = new UserDTO();
		logger.info("Request para el id del usuario");
		int Random =(int )(Math.random() * 1000000 + 100000);
		userDTO.setConfCode(Integer.toString(Random));
		userDTO.setConfStatus(false);
		
		DBuserDTO = DBuserDTO.valueOf(userRepo.findBycorreo(userDTO.getCorreo()));

		
		if(DBuserDTO==null) 
		{
			UserEntity userEntity = userDTO.createEntity(userDTO);
			userRepo.save(userEntity);
			return true;
		}else 
		{
			return false;
		}
			
		
		
		
	}

	public List<UserDTO> getUsers() {
		logger.info("Request para lista de usuarios");
		UserDTO userDTO = new UserDTO();
		List<UserDTO> userList = new ArrayList<>();
		
		for(UserEntity user: userRepo.findAll()) 
		{
			userList.add(userDTO.valueOf(user));
		}
		
		return userList;
	}
	
	public void getUserByEmail(String email) 
	{
		logger.info("Request para lista de usuarios busqueda por email");
		UserDTO userDTO = new UserDTO();
		
		userDTO = userDTO.valueOf(userRepo.findBycorreo(email));
		
		Mail mail = new Mail();
        mail.setMailFrom("jes.gallardo.d@gmail.com");
        mail.setMailTo(userDTO.getCorreo());
        mail.setMailSubject("Verificacion de correo aplicacion de Messenger");
        mail.setMailContent("tu codigo de verificacion es el siguiente: " + userDTO.getConfCode());
        
        mailService.sendEmail(mail);
       
	}
	
	public Boolean verifyUser(String email, String verCode) 
	{
		logger.info("Request para lista de usuarios busqueda por email");
		UserDTO userDTO = new UserDTO();
		
		userDTO = userDTO.valueOf(userRepo.findBycorreo(email));
		
		if(verCode.equals(userDTO.getConfCode())) 
		{
			userDTO.setConfStatus(true);
			userRepo.save(userDTO.createEntity(userDTO));
			return true;
		}else 
		{
			return false;
		}
		
	}
	

}
