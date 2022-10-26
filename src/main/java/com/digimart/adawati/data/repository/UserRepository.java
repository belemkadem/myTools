package com.digimart.adawati.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimart.adawati.data.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName); 
}
