package com.springboot.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.jwt.model.User;
import com.springboot.jwt.repository.UserRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmailIgnoreCase(username);
		if(user==null) {
			throw new UsernameNotFoundException(String.format("No User Name Found with UserName '%s'", username));
		}
		else
		{
			return JwtuserFactory.create(user);
		}
	}

}
