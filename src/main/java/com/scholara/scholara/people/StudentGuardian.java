package com.scholara.scholara.people;

import jakarta.persistence.*;

@Entity
@Table(name = "student_guardians")
public class StudentGuardian {

    @EmbeddedId
    private StudentGuardianId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("studentId")
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("guardianId")
    @JoinColumn(name = "guardian_id", nullable = false)
    private Guardian guardian;

    @Column(nullable = false, length = 30)
    private String relationship;

    @Column(name = "is_primary", nullable = false)
    private boolean primary;
}
