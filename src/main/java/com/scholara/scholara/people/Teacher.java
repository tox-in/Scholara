package com.scholara.scholara.people;

import com.scholara.scholara.identity.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Column(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "employee_number", nullable = false, unique = true, length = 50)
    private String employeeNumber;

    @Co
    private LocalDate hireDate;
}
