package com.digimart.adawati.business.impl.user;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digimart.adawati.business.api.user.UserBusinessService;
import com.digimart.adawati.business.mapper.UserMapperServiceImpl;
import com.digimart.adawati.data.entity.user.User;
import com.digimart.adawati.data.repository.UserRepository;
import com.digimart.adawati.dto.representation.UserInfoRepresentation;
import com.digimart.adawati.error.exception.UserNotFoundExcpetion;

@Service
@Transactional(value=TxType.REQUIRED,rollbackOn=Exception.class)
public class UserBusinessServiceImpl implements UserBusinessService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapperServiceImpl userMapperServiceImpl;
	
	@Override
	public UserInfoRepresentation getUserInfo(String userName) throws UserNotFoundExcpetion {
		User user = userRepository.findByUserName(userName);
		if(user==null) {
			throw new UserNotFoundExcpetion(userName);
		}
		return userMapperServiceImpl.toInfoRepresentation(user);
	}
}
