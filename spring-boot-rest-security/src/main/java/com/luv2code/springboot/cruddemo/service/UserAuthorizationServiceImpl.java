package com.luv2code.springboot.cruddemo.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.UserAuthrizationRepository;
import com.luv2code.springboot.cruddemo.entity.AppUser;

@Service
public class UserAuthorizationServiceImpl implements UserDetailsService {

	private final UserAuthrizationRepository userAuthrizationRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserAuthorizationServiceImpl(UserAuthrizationRepository userAuthrizationRepository) {
		this.userAuthrizationRepository = userAuthrizationRepository;
	}

	public void save(AppUser appUser) {
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
		userAuthrizationRepository.save(appUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUser = Optional.of(userAuthrizationRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + "User Not Found ")));

		return new org.springframework.security.core.userdetails.User(appUser.get().getUserName(),
				appUser.get().getPassword(),
				Collections.singleton(new SimpleGrantedAuthority(appUser.get().getRole())));
	}

}
