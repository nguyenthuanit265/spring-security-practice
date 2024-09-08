package com.learn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    @GetMapping("/profiles")
    public ResponseEntity<String> getProfiles() {
        return ResponseEntity.ok().body("Admin profiles");
    }
}
