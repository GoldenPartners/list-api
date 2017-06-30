package dev.jpp.listapi.security;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {
	private static final long serialVersionUID = -1690283255712605851L;

	private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
