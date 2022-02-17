package com.messenger.MessengerApis.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.messenger.MessengerApis.Entity.UserEntity;
import com.messenger.MessengerApis.Repository.CallUserRepository;
import com.messenger.MessengerApis.dto.UserDTO;


@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CallUserRepository userRepo;
	
	public UserDTO getUser(@PathVariable long id) 
	{
		
		logger.info("Request para el id del usuario");
		
		UserDTO userDTO = new UserDTO();
		userDTO = userDTO.valueOf(userRepo.getById(id)) ;
		return userDTO;
	}
	
	public void saveUser(UserDTO userDTO) 
	{
		
		logger.info("Request para el id del usuario");
		UserEntity userEntity = userDTO.createEntity(userDTO);
		userRepo.save(userEntity);
		
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
	

}
