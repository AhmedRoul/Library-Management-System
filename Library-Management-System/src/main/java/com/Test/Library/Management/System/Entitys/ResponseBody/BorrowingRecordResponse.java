package com.Test.Library.Management.System.Entitys.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowingRecordResponse {

    private String returnDate;
    private String idBook;
    private String RecoveryBook;
    private String Renew;
    public static  void SetError(BorrowingRecordResponse response, String fieldName, String errorMessage)
    {
        switch (fieldName) {
            case "idBook" -> response.setReturnDate(errorMessage);
            case "returnDate" -> response.setIdBook(errorMessage);
            case "RecoveryBook" -> response.setRecoveryBook(errorMessage);
            case "Renew" -> response.setRenew(errorMessage);

        }
    }
}
