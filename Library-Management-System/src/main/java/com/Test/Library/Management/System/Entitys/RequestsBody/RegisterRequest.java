package com.Test.Library.Management.System.Entitys.RequestsBody;

import com.Test.Library.Management.System.Entitys.Librarian;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Email(message = "INVALID EMAIL ADDRESS")
    private String email;


    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,20}$"
            ,message = "Password must be at least 8 characters long , at most 20 characters,contain at least one digit, one lowercase letter, one uppercase letter, and one letter.")
    private String password;


    @Size(min = 3,max = 20,message = "First name must be at least 8 characters long, at most 20 characters")
    private String firstname;


    @Size(min = 3,max = 20,message = "Last name must be at least 8 characters long, at most 20 characters")
    private String lastname;



    public Librarian GetLibrarian(){
        return Librarian.builder().firstName(this.firstname).lastName(this.lastname).email(this.email).password(this.password).build();
    }

}
