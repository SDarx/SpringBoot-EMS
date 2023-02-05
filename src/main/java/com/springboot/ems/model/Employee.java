package com.springboot.ems.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(
            name = "firstName",
            nullable = false
    )
    private String  FirstName;
    @Column(
            name = "lastName",
            nullable = false
    )
    private String LastName;

    private String email;
}
