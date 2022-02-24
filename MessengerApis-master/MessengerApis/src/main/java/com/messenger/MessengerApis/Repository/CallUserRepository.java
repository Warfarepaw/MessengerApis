package com.messenger.MessengerApis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.messenger.MessengerApis.Entity.UserEntity;

@Repository
public interface CallUserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findBycorreo(String correo);
}
