package com.Test.Library.Management.System.Entitys.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    public static  void SetError(RegisterResponse registerResponse, String fieldName, String errorMessage)
    {
        switch (fieldName) {
            case "email" -> registerResponse.setEmail(errorMessage);
            case "password" -> registerResponse.setPassword(errorMessage);
            case "lastname" -> registerResponse.setLastname(errorMessage);
            case "firstname" -> registerResponse.setFirstname(errorMessage);

        }
    }

}
