package com.example.validationdemo.dto;

import com.example.validationdemo.domain.Admin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdminRequest {
    @NotBlank
    private String name;

    public Admin toAdmin() {
        return Admin.builder()
                .name(this.name)
                .build();
    }
}
