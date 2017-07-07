package dev.jpp.listapi.security;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtAuthenticationResponse implements Serializable {
	private static final long serialVersionUID = -1690283255712605851L;

	private final UserDetails user;
	private final String token;

    public JwtAuthenticationResponse(String token, UserDetails user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }
    
    public UserDetails getUser() {
        return this.user;
    }
}
