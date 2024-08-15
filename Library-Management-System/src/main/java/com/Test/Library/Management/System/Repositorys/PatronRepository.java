package com.Test.Library.Management.System.Repositorys;

import com.Test.Library.Management.System.Entitys.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Integer>
{

}
