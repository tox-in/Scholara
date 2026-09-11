package com.scholara.scholara.people;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentGuardianId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "guardian_id")
    private Long guardianId;
}
