package com.Test.Library.Management.System.Controllers;


import com.Test.Library.Management.System.Config.Password.CustomPasswordEncoder;
import com.Test.Library.Management.System.Entitys.Librarian;
import com.Test.Library.Management.System.Entitys.RequestsBody.RegisterRequest;
import com.Test.Library.Management.System.Entitys.ResponseBody.RegisterResponse;
import com.Test.Library.Management.System.Repositorys.LibrarianRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/register")
@Slf4j
public class RegisterController {
    @Autowired
    LibrarianRepository repository;
    @Autowired
    CustomPasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> SignUp( @RequestBody@Valid   RegisterRequest registerRequest){

        if(repository.existsByEmail(registerRequest.getEmail())){

            RegisterResponse registerResponse = RegisterResponse.builder().email("Email already exists").build();
           return ResponseEntity.badRequest().body(registerResponse);
        }

        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Librarian librarian=repository.save(registerRequest.GetLibrarian());

        return ResponseEntity.ok().body("redirect to login page ");
    }
}
