package com.haven.publicforum.security;

import com.haven.publicforum.post.model.HavenUserDetails;
import com.haven.publicforum.post.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final RestTemplate restTemplate;

    @Autowired
    public JwtRequestFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = httpServletRequest.getHeader("Authorization");

        User user = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            user = restTemplate.getForObject(
                    "http://user-authentication/validate-token/" + authorizationHeader.substring(7), User.class);
        }

        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = Optional.of(user).map(HavenUserDetails::new).get();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource()
                    .buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }


        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
