package com.Test.Library.Management.System.Entitys.RequestsBody;

import com.Test.Library.Management.System.Entitys.Patron;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.util.Pair;

import java.util.Calendar;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatronPutRequest {
    @NotBlank(message = "Patron name cannot be empty")
    @Size(max = 50, min=5, message = "Patron name cannot be more than 50 characters or less than 5 characters")
    private String name;

    @NotBlank(message = "Patron contact Information cannot be empty")
    @Email(message = "Not valid email")
    private String contactInformation;
    @NotBlank(message = "Patron address cannot be empty")
    @Size(max = 200, min=5, message = "Patron address cannot be more than 200 characters or less than 5 characters")
    private String address;

    /**
     * The `Renew` field represents a pair of values indicating whether a patron wants to renew their membership
     * and, if so, for how many additional months.
     *
     * The first element (Boolean) specifies whether the renewal is requested (`true` for yes, `false` for no).
     * The second element (Integer) specifies the number of months to renew.
     *
     * For example:
     * - `<true, 6>` indicates that the patron wishes to renew their membership for an additional 6 months.
     * - `<false, 0>` indicates no renewal is requested.
     *
     * This field is annotated with `@NotBlank` to ensure that a valid pair is provided.
     * The custom message `"Renew element cannot be empty {if you don't need renew set pair <false ,0>}"`
     * guides users to either specify a valid renewal request or use `<false, 0>` if no renewal is required.
     */
    @NotBlank(message = "Renew element cannot be empty {if you dont't need renew set pair <false ,0>}")
    private Pair< Boolean ,Integer> Renew;

    public Patron getEditPatron(Patron patron){

        patron.setAddress(address);
        patron.setName(name);
        patron.setContactInformation(contactInformation);

        if(Renew.getFirst()){
           int numMonths= Renew.getSecond();
           if(numMonths==0)
               numMonths=1;
           patron.setMembershipStartDate(Calendar.getInstance());
           patron.setMembershipExpiryDate(Calendar.getInstance());
           patron.getMembershipExpiryDate().add(Calendar.DAY_OF_MONTH, numMonths *30);
        }

        return patron;
    }

}
