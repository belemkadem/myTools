package com.digimart.adawati.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.digimart.adawati.business.api.user.UserBusinessService;
import com.digimart.adawati.dto.representation.UserInfoRepresentation;
import com.digimart.adawati.error.exception.UserNotFoundExcpetion;

@RestController
public class UserController {
	
	
	@Autowired
	UserBusinessService UserBusinessService;
	
	@GetMapping("/v1/user/{userName}")
	public UserInfoRepresentation getUserInfo(@PathVariable(value="userName") String userName) throws UserNotFoundExcpetion{
		return UserBusinessService.getUserInfo(userName);
	}
	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

}
