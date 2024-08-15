package com.Test.Library.Management.System.Entitys.RequestsBody;

import com.Test.Library.Management.System.Entitys.Book;
import com.Test.Library.Management.System.Validation.ValidISBN;
import com.Test.Library.Management.System.Validation.ValidYear;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @Size(max = 500, min=10, message = "Book title cannot be more than 500 characters or less than 10 characters")
    private String title;


    @Size(max = 70, min=3, message = "Book author cannot be more than 70 characters or less than 3 characters")
    private String author;
    @NotBlank(message = "Book isbn cannot be empty")
    @ValidISBN
    private String isbn;

    @ValidYear
    private short publisherYear;
    @Min(value = 0, message = "Number of copies cannot be less than 0")
    private int numOfCopies;


    @Size(max = 75, min=3, message = "Book type cannot be more than 75 characters or less than 3 characters")
    private String   type;

    public Book getNewBook(){
        return Book.builder()
                .author(author)
                .title(title)
                .type(type)
                .publisherYear(publisherYear)
                .numOfCopies(numOfCopies)
                .isbn(isbn)
                .build();
    }
    public Book getEditBook(Book book){
        book.setAuthor(author);
        book.setIsbn(isbn);//
        book.setPublisherYear(publisherYear);
        book.setType(type);
        book.setTitle(title);
        book.setNumOfCopies(numOfCopies);
        return book;
    }


}
