package com.Test.Library.Management.System.Entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="librarian")
public class Librarian {
    @Id
    @SequenceGenerator(name = "librarians_seq", sequenceName = "librarian_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "librarians_seq")
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
