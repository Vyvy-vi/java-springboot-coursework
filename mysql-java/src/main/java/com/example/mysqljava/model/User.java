package com.example.mysqljava.model;

import com.example.mysqljava.MysqlJavaApplication;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="UserDetails")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
