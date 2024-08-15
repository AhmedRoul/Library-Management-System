package com.Test.Library.Management.System.Entitys.RequestsBody;
import com.Test.Library.Management.System.Entitys.Librarian;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class loginRequest {
    @Email(message = "INVALID_EMAIL_ADDRESS")
    @NotBlank(message = "EMAIL_CANNOT_BE_EMPTY")
    private String email;


    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,100}$"
            ,message = "INVALID_EMAIL_ADDRESS")
    private String password;
    public Librarian GetLibrarian(){
        return Librarian.builder().email(this.email).build();
    }
}
