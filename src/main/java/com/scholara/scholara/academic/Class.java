package com.scholara.scholara.academic;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYear academicYear;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "grade_level", nullable = false, length = 30)
    private String gradeLevel;

    @Column
    private Integer capacity;
}
