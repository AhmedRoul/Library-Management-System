package com.Test.Library.Management.System.Repositorys;

import com.Test.Library.Management.System.Entitys.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Integer>
{
    @Query("SELECT b FROM BorrowingRecord b WHERE b.book.id = :book_id AND b.patron.id = :patron_id")
    BorrowingRecord getBorrowingRecord(@Param("book_id") int bookId,
                                       @Param("patron_id") int patronId);

}
