package com.example.validationdemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @Table annotation - used for different Table Name
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // AUTO - Hibernate will generate ID
    // IDENTITY - Underlying database server (MySQL) will generate ID
    private int id;
    // if we use IDENTITY, the AUTO INCREMENT is passed in the
    //  CREATE TABLE statement
    // else, the id is set in the query sent to sql by Hibernate (spring-boot)
    // since we're using update, we can't switch mid-way


    // @Column annotation - used for different column name, and can be used to add Annotations.
    private String name;
    private String address;
    private int age;
}
