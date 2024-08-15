package com.Test.Library.Management.System.Entitys.RequestsBody;

import com.Test.Library.Management.System.Entitys.Patron;
import com.Test.Library.Management.System.Validation.ValidExpiryDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatronPostRequest {

    @Size(max = 50, min=5, message = "Patron name cannot be more than 50 characters or less than 5 characters")
    private String name;


    @Email(message = "Not valid email")
    private String contactInformation;

    @Size(max = 200, min=5, message = "Patron address cannot be more than 200 characters or less than 5 characters")
    private String address;

    // If it does not exist it will be replaced with today's date
    private Calendar membershipStartDate;

    //If it does not exist it will be replaced with today's date + 30 day
    @ValidExpiryDate
    private Calendar membershipExpiryDate;

    public Patron getNewPatron(){

        if(this.membershipStartDate==null)
        {
            this.membershipStartDate= Calendar.getInstance();
        }
        if(this.membershipStartDate==null&&this.membershipExpiryDate==null)
        {
           this.membershipExpiryDate=Calendar.getInstance();
           this.membershipExpiryDate.add(Calendar.DAY_OF_MONTH, 30);// Add 30 day
        }
        return  Patron.builder()
                .address(address)
                .name(name)
                .membershipExpiryDate(membershipExpiryDate)
                .membershipStartDate(membershipStartDate)
                .contactInformation(contactInformation)
                .build();
    }

}
