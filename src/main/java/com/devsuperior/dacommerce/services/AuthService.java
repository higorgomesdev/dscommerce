package com.devsuperior.dacommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dacommerce.entities.Role;
import com.devsuperior.dacommerce.entities.User;
import com.devsuperior.dacommerce.services.exceptions.ForbiddenException;

@Service
public class AuthService {

	@Autowired
	UserService userService;
	
	public void validateselfOrAdmin(Long userId) {
		User user = userService.authenticated();
		Role role = new Role();
		role.setAuthority("ROLE_ADMIN");		
		if(!user.getId().equals(userId) && !user.hasRole(role)) {	
			throw new ForbiddenException("unauthorized");
		}
	}
}
