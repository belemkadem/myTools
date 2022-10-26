package com.digimart.adawati.business.mapper;

import org.springframework.stereotype.Service;

import com.digimart.adawati.data.entity.user.User;
import com.digimart.adawati.dto.representation.UserInfoRepresentation;

@Service
public class UserMapperServiceImpl {

	public UserInfoRepresentation toInfoRepresentation(User user) {
		return UserInfoRepresentation.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.state(user.getState()!=null?user.getState().name():null)
				.userName(user.getUserName())
				.build();
	}

}
