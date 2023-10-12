package com.example.validationdemo.service;

import com.example.validationdemo.domain.Admin;
import com.example.validationdemo.repository.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void createAdmin(@RequestBody @Valid Admin admin) {
        adminRepository.save(admin);
    }


}
