package com.Test.Library.Management.System.Entitys.RequestsBody;

import com.Test.Library.Management.System.Entitys.BorrowingRecord;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.util.Pair;

import java.util.Calendar;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingRecordPutRequest {

    private  int idBook;

    @NotBlank(message = "Recovery Book  cannot be empty")
    private boolean RecoveryBook;

    /**
     * The `Renew` field represents whether a patron wishes to renew their membership
     * and, if so, the duration of the renewal.
     *
     * - The first element (Boolean) indicates if renewal is requested (`true` for yes, `false` for no).
     * - The second element (Integer) specifies the number of additional months requested for renewal.
     *
     * Examples:
     * - `<true, 6>`: The patron requests a 6-month membership renewal.
     * - `<false, 0>`: No renewal is requested.
     *
     * This field is annotated with `@NotBlank` to ensure a valid pair is provided.
     * The custom message `"Renew element cannot be empty {if you don't need renewal, set pair <false, 0>}"`
     * instructs users to specify a renewal request or use `<false, 0>` if no renewal is needed.
     */
    @NotBlank(message = "Renew element cannot be empty {if you don't need renewal, set pair <false, 0>}")
    private Pair<Boolean, Integer> Renew;

    public BorrowingRecord getEditBorrowingRecord(BorrowingRecord borrowingRecord)
    {
        borrowingRecord.setRecoveryBook(RecoveryBook);
        if(Renew.getFirst()){
            int numMonths= Renew.getSecond();
            if(numMonths==0)
                numMonths=1;
            borrowingRecord.setReturnDate(Calendar.getInstance());
            borrowingRecord.getReturnDate().add(Calendar.DAY_OF_MONTH, numMonths *30);
        }
        return borrowingRecord;

    }

}
