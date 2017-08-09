package dev.jpp.listapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.jpp.listapi.security.JwtAuthenticationRequest;
import dev.jpp.listapi.security.JwtAuthenticationResponse;
import dev.jpp.listapi.security.JwtTokenUtil;

@RestController
public class AuthenticationRestController {
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authReq, Device device) throws AuthenticationException {
        // Perform the security
        final Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Reload password post-security so we can generate token
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
        final UserDetails userDetails = (UserDetails) auth.getPrincipal();
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token, userDetails));
    }
}
