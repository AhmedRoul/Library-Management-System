package com.Test.Library.Management.System.Entitys.RequestsBody;

import com.Test.Library.Management.System.Entitys.BorrowingRecord;
import com.Test.Library.Management.System.Validation.ValidExpiryDate;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingRecordPostRequest {

    @ValidExpiryDate
    private Calendar returnDate;

    public BorrowingRecord  getNewBorrowingRecord(BorrowingRecord borrowingRecord)
    {
        borrowingRecord.setBorrowDate(Calendar.getInstance());
        borrowingRecord.setReturnDate(Calendar.getInstance());
        borrowingRecord.getReturnDate().add(Calendar.DAY_OF_MONTH, 15);//15 days
        borrowingRecord.setRecoveryBook(false);
        return  borrowingRecord;
    }


}
