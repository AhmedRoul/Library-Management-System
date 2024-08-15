package com.Test.Library.Management.System.Exceptions;

import com.Test.Library.Management.System.Entitys.RequestsBody.*;
import com.Test.Library.Management.System.Entitys.ResponseBody.BookResponse;
import com.Test.Library.Management.System.Entitys.ResponseBody.BorrowingRecordResponse;
import com.Test.Library.Management.System.Entitys.ResponseBody.PatronResponse;
import com.Test.Library.Management.System.Entitys.ResponseBody.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        Object Response=new Object();
        Object obj=ex.getTarget();

        //if Not Valid from Book controller {PostRequest or PutRequest}
        if(obj instanceof BookRequest)
        {
            Response= BookResponse.builder().build();
        }
        else if (obj instanceof PatronPutRequest||obj instanceof PatronPostRequest){
            Response= PatronResponse.builder().build();
        }
        else if (obj instanceof BorrowingRecordPutRequest ||obj instanceof BorrowingRecordPostRequest){
            Response= PatronResponse.builder().build();
        }
        else if (obj instanceof loginRequest){
            return  ResponseEntity.badRequest().body("INVALID  Email and Password");
        }
        else if (obj instanceof RegisterRequest ){
            Response= RegisterResponse.builder().build();
        }

         else
            return ResponseEntity.badRequest().body("check your code!!");


        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            if(Response instanceof BookResponse) //check if Response is Book Response class
            {
                BookResponse.SetError((BookResponse) Response, fieldName, errorMessage);
            }
            else if (Response instanceof PatronResponse)//check if Response is Patron Response class
            {
                PatronResponse.SetError((PatronResponse) Response,fieldName, errorMessage);
            }
            else if (Response instanceof BorrowingRecordResponse)//check if Response is Borrowing Record Response class
            {
                BorrowingRecordResponse.SetError((BorrowingRecordResponse) Response,fieldName, errorMessage);
            }
            else if (Response instanceof RegisterResponse)//check if Response is Register  Response class
            {
                RegisterResponse.SetError((RegisterResponse) Response,fieldName, errorMessage);
            }
            else
                return ResponseEntity.badRequest().body("check your code!!");

        }

        //sent error
        return ResponseEntity.badRequest().body(Response);
    }


}
