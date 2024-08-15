package com.Test.Library.Management.System.Repositorys;

import com.Test.Library.Management.System.Entitys.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian,Integer>
{
    public Librarian  findByEmail(String email);

    public  boolean existsByEmail(String email);
}
