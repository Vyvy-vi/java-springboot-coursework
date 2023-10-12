package com.example.validationdemo.repository;

import com.example.validationdemo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
}
