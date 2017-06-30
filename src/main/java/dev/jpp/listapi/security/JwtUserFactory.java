package dev.jpp.listapi.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.entity.UserRole;

public class JwtUserFactory {
	
	private JwtUserFactory() {
		super();
    }

    public static JwtUser create(User user) {
        return new JwtUser(
        		user.getId(),
        		user.getName(),
        		user.getPhone(),
        		user.getEmail(),
        		user.getPassword(),
        		mapToGrantedAuthorities(user.getRoles()),
        		user.getEnabled()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<UserRole> authorities) {
        List<GrantedAuthority> roles = new ArrayList<>();
        Iterator<UserRole> iterator = authorities.iterator();
        
        while (iterator.hasNext()) {
			UserRole userRole = iterator.next();
			roles.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
        
        return roles;
    }
    
}
