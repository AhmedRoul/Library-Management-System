package com.Test.Library.Management.System.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="patron")
public class Patron {

    @Id
    @SequenceGenerator(name = "patron_seq", sequenceName = "patron_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patron_seq")
    private Long id;
    private String name;

    @Column(name = "email",unique=true)
    private String contactInformation;
    private String address;
    private Calendar membershipStartDate;

    private Calendar  membershipExpiryDate;

    @OneToMany(mappedBy = "patron")
    private List<BorrowingRecord> borrowingRecords;
}
