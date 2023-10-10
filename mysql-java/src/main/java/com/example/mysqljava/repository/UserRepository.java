package com.example.mysqljava.repository;

import com.example.mysqljava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JPARepository inherits from CRUDRepository

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    User findByEmail(String email);
}
