package com.Test.Library.Management.System.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name ="borrowing_record")
public class BorrowingRecord {

    @Id
    @SequenceGenerator(name = "patron_seq", sequenceName = "patron_sequence",initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patron_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;         // The book being borrowed

    @ManyToOne
    @JoinColumn(name = "patron_id", referencedColumnName = "id")
    private Patron patron;

    private Calendar borrowDate;   // The date the book was borrowed
    private Calendar returnDate;
    private boolean RecoveryBook;
}
