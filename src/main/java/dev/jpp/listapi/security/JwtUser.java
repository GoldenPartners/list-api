package dev.jpp.listapi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {
	private static final long serialVersionUID = 5210005586804543150L;
	
	private final Long id;
    private final String name;
    private final String phone;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Boolean enabled;

	public JwtUser(Long id, String name, String phone, String email, String password, Collection<? extends GrantedAuthority> authorities, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.enabled = enabled;
	}
	
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return email;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public String getEmail() {
    	return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
