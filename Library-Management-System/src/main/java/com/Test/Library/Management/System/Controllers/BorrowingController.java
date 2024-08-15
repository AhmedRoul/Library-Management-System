package com.Test.Library.Management.System.Controllers;

import com.Test.Library.Management.System.Entitys.Book;
import com.Test.Library.Management.System.Entitys.BorrowingRecord;
import com.Test.Library.Management.System.Entitys.Patron;
import com.Test.Library.Management.System.Entitys.RequestsBody.BorrowingRecordPostRequest;
import com.Test.Library.Management.System.Entitys.RequestsBody.BorrowingRecordPutRequest;
import com.Test.Library.Management.System.Repositorys.BookRepository;
import com.Test.Library.Management.System.Repositorys.BorrowingRecordRepository;
import com.Test.Library.Management.System.Repositorys.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BorrowingController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    PatronRepository patronRepository;
    @Autowired
    BorrowingRecordRepository borrowingRepository;

    @CacheEvict(value = {"borrowings"}, allEntries = true)
    @Transactional
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?>  AddBorrowing(@RequestBody BorrowingRecordPostRequest request,
                                           @PathVariable  int bookId,
                                           @PathVariable  int patronId)
    {
        Optional<Book> book= bookRepository.findById(bookId);
        Optional<Patron> patron= patronRepository.findById(patronId);
        Map<String,String> map=new HashMap<>();

        if(book.isEmpty())
            map.put("BookID","Book with ID \" " + bookId + " \" does not exist");
        if(patron.isEmpty())
            map.put("PatronId","Patron with ID \" " + patronId + " \" does not exist");
        if(map.size()>0)
            return ResponseEntity.badRequest().body(map);

        BorrowingRecord borrowingRecord=BorrowingRecord.builder().book(book.get()).patron(patron.get()).build();
        borrowingRecord= request.getNewBorrowingRecord(borrowingRecord);

        BorrowingRecord saved =borrowingRepository.save(borrowingRecord);
        saved.setPatron(Patron.builder().id(saved.getId()).build());
        saved.setBook(Book.builder().id(saved.getId()).build());

        return ResponseEntity.ok("Done Add new Record");
    }

    @Cacheable(value = "borrowings", key = "#bookId + '-' + #patronId")
    @GetMapping("borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?>  getBorrowing(@PathVariable  int bookId,
                                           @PathVariable  int patronId)
    {

        return ResponseEntity.ok(borrowingRepository.getBorrowingRecord(bookId,patronId));
    }
    @CachePut(value = "borrowings", key = "#bookId + '-' + #patronId")
    @CacheEvict(value = "borrowings", allEntries = true)
    @Transactional
    @PutMapping("borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?>  EditBorrowing(@RequestBody BorrowingRecordPutRequest request, @PathVariable  int bookId,
                                            @PathVariable  int patronId)
    {
        BorrowingRecord borrowingRecord= borrowingRepository.getBorrowingRecord(bookId,patronId);
        if(borrowingRecord==null){
            return ResponseEntity.badRequest().body("BorrowingRecord not include both " +
                    "Book with ID " + bookId + "  and Patron with ID " +patronId + " . \nTry Again.");
        }
        borrowingRecord=request.getEditBorrowingRecord(borrowingRecord);
        if(!request.isRecoveryBook()&&request.getIdBook()!=0)
        {
            Optional<Book> book= bookRepository.findById(request.getIdBook());
            if(book.isPresent()){
                borrowingRecord.setBook(book.get());
            }
            else
            return ResponseEntity.badRequest().body("Book with ID  " + request.getIdBook() + "  does not exist");
        }
        BorrowingRecord borrowingRecord1= borrowingRepository.save(borrowingRecord);

        return ResponseEntity.ok("Done Updated Borrowing Record ");
    }

}
