package com.Test.Library.Management.System.Filters;

import com.Test.Library.Management.System.Services.LibrarianDetailsService;
import com.Test.Library.Management.System.Utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    LibrarianDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String authorizationHeader=request.getHeader("Authorization");

        String Token=null;
        String email=null;
        if(authorizationHeader!=null){
            Token=authorizationHeader.substring(7);
        }
        if(Token==null) {
            if (request.getRequestURI().equals("/api/login")||request.getRequestURI().equals("/api/register")) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        if (Token != null && !Token.isEmpty()) {
            try {
                email = jwtUtils.extractUsername(Token);
            } catch (Exception e) {
                System.out.println("Failed to extract username from token: " + e.getMessage());
            }

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                if (jwtUtils.validateToken(Token,  userDetails.getUsername())) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
                else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("Invalid JWT Token");
                }
            }
        }

        filterChain.doFilter(request, response);

    }
}
