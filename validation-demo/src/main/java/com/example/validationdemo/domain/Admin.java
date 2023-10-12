package com.example.validationdemo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "my_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // These constraints are applied on database
    @Column(name="admin_name", nullable = false, length = 100)
    private String name;
}

/*
CREATE TABLE my_admin(id INTEGER PRIMARY, admin_name VARCHAR(100) NOT NULL);
 */
