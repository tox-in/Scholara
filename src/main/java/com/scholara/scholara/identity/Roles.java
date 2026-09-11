package com.scholara.scholara.identity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length= 50)
    private String name;

    @Column(length = 255)
    private String description;

}
