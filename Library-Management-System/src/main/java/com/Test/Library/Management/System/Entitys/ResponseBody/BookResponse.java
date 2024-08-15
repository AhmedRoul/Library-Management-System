package com.Test.Library.Management.System.Entitys.ResponseBody;

import com.Test.Library.Management.System.Validation.ValidISBN;
import com.Test.Library.Management.System.Validation.ValidYear;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse
{
    private String title;
    private String author;
    private String isbn;
    private String publisherYear;
    private String numOfCopies;
    private String   type;

    public static  void SetError(BookResponse bookResponse,String fieldName,String errorMessage)
    {
        switch (fieldName) {
            case "title" -> bookResponse.setTitle(errorMessage);
            case "author" -> bookResponse.setAuthor(errorMessage);
            case "isbn" -> bookResponse.setIsbn(errorMessage);
            case "publisherYear" -> bookResponse.setPublisherYear(errorMessage);
            case "numOfCopies" -> bookResponse.setNumOfCopies(errorMessage);
            case "type" -> bookResponse.setType(errorMessage);
        }
    }
}
