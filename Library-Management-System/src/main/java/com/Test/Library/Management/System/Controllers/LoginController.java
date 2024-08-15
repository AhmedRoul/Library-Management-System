package com.Test.Library.Management.System.Controllers;


import com.Test.Library.Management.System.Config.Password.CustomPasswordEncoder;
import com.Test.Library.Management.System.Entitys.Librarian;
import com.Test.Library.Management.System.Entitys.RequestsBody.RegisterRequest;
import com.Test.Library.Management.System.Entitys.RequestsBody.loginRequest;
import com.Test.Library.Management.System.Entitys.ResponseBody.JwtResponse;
import com.Test.Library.Management.System.Entitys.ResponseBody.RegisterResponse;
import com.Test.Library.Management.System.Repositorys.LibrarianRepository;
import com.Test.Library.Management.System.Utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/login")
@Slf4j
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtils;
    @Autowired
    CustomPasswordEncoder passwordEncoder;
    @Autowired
    LibrarianRepository repository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody  loginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            if (authentication.isAuthenticated()) {

                String token = jwtUtils.generateToken(loginRequest.getEmail());

                return ResponseEntity.ok()
                        .body(JwtResponse.builder().accessToken(token).build());
            } else
                return ResponseEntity.badRequest()
                        .body("invalid user request..!!  email or password warn");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("invalid user request..!!  email or password warn");
        }
    }


}
