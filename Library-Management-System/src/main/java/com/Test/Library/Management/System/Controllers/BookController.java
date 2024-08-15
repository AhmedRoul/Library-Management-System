package com.Test.Library.Management.System.Controllers;

import com.Test.Library.Management.System.Entitys.Book;
import com.Test.Library.Management.System.Entitys.RequestsBody.BookRequest;
import com.Test.Library.Management.System.Repositorys.BookRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Books")
public class BookController
{
    @Autowired
    private BookRepository bookRepository;


    @Cacheable(value = "books")
    @GetMapping
    public ResponseEntity<?> getAllBooks()
    {
      List<Book> list=bookRepository.findAll();

        list.forEach(book ->
                book.getBorrowingRecords().forEach(borrowingRecord -> {
                    borrowingRecord.getPatron().setBorrowingRecords(null);
                    borrowingRecord.getBook().setBorrowingRecords(null);
                })
        );
        return   ResponseEntity.ok(list);
    }

    @Cacheable(value = "book", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable  int id)
    {
       Optional<Book> book =bookRepository.findById(id);
       if(book.isPresent()) {
           book.get().getBorrowingRecords().forEach(borrowingRecord -> {
                       borrowingRecord.getPatron().setBorrowingRecords(null);
                       borrowingRecord.getBook().setBorrowingRecords(null);
                   }
           );
           return ResponseEntity.ok(book);
       }
       else
       {
           return ResponseEntity.ok("{}");
       }
    }

    @CacheEvict(value = "books", allEntries = true)
    @Transactional
    @PostMapping
    public ResponseEntity<?> AddBook(@Valid @RequestBody BookRequest bookRequest)
    {
        Book book=bookRepository.save(bookRequest.getNewBook());
        return ResponseEntity.ok("done");
    }
    @CachePut(value = "book", key = "#id")
    @CacheEvict(value = "books", allEntries = true)
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> EditBook(@Valid  @RequestBody BookRequest bookRequest, @PathVariable  int id)
    {
        Optional<Book> book= bookRepository.findById(id);
        if(book.isPresent()){
            Book bookUpdated=bookRequest.getEditBook(book.get());
            bookRepository.save(bookUpdated);
            return ResponseEntity.ok("Done Edit Book");
        }
        return ResponseEntity.badRequest().body("Book with ID \" " + id + " \" does not exist");

    }

    @Transactional
    @DeleteMapping("/{id}")
    @CacheEvict(value = {"book", "books"}, key = "#id", allEntries = true)
    public ResponseEntity<?> DeleteBook(@PathVariable  int id)
    {
        try{
            if (!bookRepository.existsById(id)) {
                return ResponseEntity.badRequest().body("Book with ID \" " + id + " \" does not exist");
            }
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Done Deleted");
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }



}
