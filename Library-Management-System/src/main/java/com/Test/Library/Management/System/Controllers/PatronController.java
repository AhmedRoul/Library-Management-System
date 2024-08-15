package com.Test.Library.Management.System.Controllers;
import com.Test.Library.Management.System.Entitys.Book;
import com.Test.Library.Management.System.Entitys.Patron;
import com.Test.Library.Management.System.Entitys.RequestsBody.PatronPostRequest;
import com.Test.Library.Management.System.Entitys.RequestsBody.PatronPutRequest;
import com.Test.Library.Management.System.Repositorys.PatronRepository;
import jakarta.persistence.EntityNotFoundException;
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
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronRepository repository;

    @Cacheable(value = "patrons")
    @GetMapping
    public ResponseEntity<?> getAllPatrons()
    {
        List<Patron> list=repository.findAll();
        list.forEach(book ->
                book.getBorrowingRecords().forEach(borrowingRecord -> {
                    borrowingRecord.getPatron().setBorrowingRecords(null);
                    borrowingRecord.getBook().setBorrowingRecords(null);
                })
        );
        return   ResponseEntity.ok(list);
    }

    @Cacheable(value = "patron", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatron(@PathVariable  int id)
    {
        Optional<Patron> patron =repository.findById(id);
        if(patron.isPresent()) {
            patron.get().getBorrowingRecords().forEach(borrowingRecord -> {
                        borrowingRecord.getPatron().setBorrowingRecords(null);
                        borrowingRecord.getBook().setBorrowingRecords(null);
                    }
            );
            return ResponseEntity.ok(patron);
        }
        else
        {
            return ResponseEntity.ok("{}");
        }
    }

    @CacheEvict(value = "patrons", allEntries = true)
    @Transactional
    @PostMapping
    public ResponseEntity<?> AddPatron(@Valid @RequestBody PatronPostRequest patronPostRequest)
    {
        Patron patron =repository.save(patronPostRequest.getNewPatron());
        return ResponseEntity.ok("Done Add new patron ");
    }
    @CachePut(value = "patron", key = "#id")
    @CacheEvict(value = "patrons", allEntries = true)
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> EditPatron(@RequestBody PatronPutRequest patronPutRequest, @PathVariable  int id)
    {
        Optional<Patron> patron= repository.findById(id);
        if(patron.isPresent()){
            Patron patronUpdated=patronPutRequest.getEditPatron(patron.get());
            repository.save(patronUpdated);
            return ResponseEntity.ok("Done Updated Patron");
        }
        return ResponseEntity.badRequest().body("Patron with ID \" " + id + " \" does not exist");
    }
    @Transactional
    @DeleteMapping("/{id}")
    @CacheEvict(value = {"patron", "patrons"}, key = "#id", allEntries = true)
    public ResponseEntity<?> DeletePatron(@PathVariable  int id)
    {
        try{
            if (!repository.existsById(id)) {
                return ResponseEntity.badRequest().body("Patron with ID \" " + id + " \" does not exist");
            }
            repository.deleteById(id);
            return ResponseEntity.ok("Done Deleted");
        }
        catch (EntityNotFoundException e)
        {
            return ResponseEntity.badRequest().body(e.getCause());
        }

    }
}
