package com.example.validationdemo.controller;

import com.example.validationdemo.dto.CreateAdminRequest;
import com.example.validationdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public void createAdmin(CreateAdminRequest createAdminRequest) {
        adminService.createAdmin(createAdminRequest.toAdmin());
    }
}
