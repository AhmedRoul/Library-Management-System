package com.Test.Library.Management.System.Services;


import com.Test.Library.Management.System.Entitys.Librarian;
import com.Test.Library.Management.System.Repositorys.LibrarianRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class LibrarianDetailsService implements UserDetailsService {
    @Autowired
    LibrarianRepository repository;
    @Cacheable(value = "librarianDetails", key = "#email")
    @Override
    public UserDetails loadUserByUsername(String email)  {

        Librarian librarian=repository.findByEmail(email);

        if(librarian == null) {

            throw new UsernameNotFoundException("Unknown user "+ email);
        }

        //accountNonExpired, credentialsNonExpired, accountNonLocked, authorities properties
        return User.withUsername(librarian.getEmail())
                .password(librarian.getPassword())
                .authorities("LIBRARIAN")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }
}

