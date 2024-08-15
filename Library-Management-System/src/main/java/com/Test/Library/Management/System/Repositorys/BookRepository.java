package com.Test.Library.Management.System.Repositorys;

import com.Test.Library.Management.System.Entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer>
{

}
