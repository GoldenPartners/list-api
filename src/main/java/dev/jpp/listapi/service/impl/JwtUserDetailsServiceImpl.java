package dev.jpp.listapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.repository.UserRepository;
import dev.jpp.listapi.security.JwtUserFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
	}

}
