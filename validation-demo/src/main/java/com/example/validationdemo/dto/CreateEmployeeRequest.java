package com.example.validationdemo.dto;

import com.example.validationdemo.domain.Employee;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public class CreateEmployeeRequest {
    @NotBlank
    private String name;

    private String address;

    @Min(18)
    @Max(60)
    private int age;

    public Employee toEmployee() {
        System.out.println(this.name + this.address + this.age);
        return Employee.builder()
                .name(this.name)
                .address(this.address)
                .age(this.age)
                .build();
    }
}
