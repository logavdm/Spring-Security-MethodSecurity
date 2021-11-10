package com.loga.work.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loga.work.model.User;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	
	Map<String,UserDetails> mapUsers=new LinkedHashMap<>();
	
	public UserServiceImpl() {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		User user1=new User("9894431212", encoder.encode("2005"), "DEVELOPER");
		User user2=new User("9894431213",encoder.encode("2005"), "ADMINISTRATOR");
		mapUsers.put(user1.getUsername(), user1);
		mapUsers.put(user2.getUsername(), user2);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return mapUsers.get(username);
	}

}
