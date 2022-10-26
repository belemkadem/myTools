package com.digimart.adawati.business.api.user;

import com.digimart.adawati.dto.representation.UserInfoRepresentation;
import com.digimart.adawati.error.exception.UserNotFoundExcpetion;

public interface UserBusinessService {

	UserInfoRepresentation getUserInfo(String userName) throws UserNotFoundExcpetion;

}
