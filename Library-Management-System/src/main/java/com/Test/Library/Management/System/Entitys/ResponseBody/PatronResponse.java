package com.Test.Library.Management.System.Entitys.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatronResponse
{
    private String name;
    private String contactInformation;
    private String address;
    private String membershipExpiryDate;
    private String Renew;
    public static  void SetError(PatronResponse patronResponse, String fieldName, String errorMessage)
    {
        switch (fieldName) {
            case "name" -> patronResponse.setName(errorMessage);
            case "contactInformation" -> patronResponse.setContactInformation(errorMessage);
            case "address" -> patronResponse.setAddress(errorMessage);
            case "membershipExpiryDate" -> patronResponse.setMembershipExpiryDate(errorMessage);
            case "Renew" -> patronResponse.setRenew(errorMessage);

        }
    }
}
