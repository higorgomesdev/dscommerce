package com.devsuperior.dacommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.devsuperior.dacommerce.entities.Role;
import com.devsuperior.dacommerce.entities.User;
import com.devsuperior.dacommerce.projections.UserDetailsProjection;
import com.devsuperior.dacommerce.repositories.UserRepository;

public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
		if(result.size() == 0) {
			throw new UsernameNotFoundException("User not Found");
		}
		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());
		for(UserDetailsProjection roleInstance : result) {
			Role role = new Role(roleInstance.getRoleId(), roleInstance.getAuthority());
			user.addRole(role);
		}
		return user;
	}

}
