package com.scholara.scholara.people;

import com.scholara.scholara.identity.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "student_number", nullable = false, unique = true, length = 50)
    private String studentNumber;

    @Column(length = 20)
    private LocalDate dateOfBirth;

    @Column(length = 20)
    private String gender;

    @Column(name = "admission_date", nullable = false)
    private LocalDate admissionDate;

    @Column(nullable = false, length = 20)
    private String status;
}
