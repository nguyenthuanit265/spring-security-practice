package com.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/profiles")
    public ResponseEntity<String> getProfiles() {
        LOGGER.info("[AdminController] getProfiles");
        return ResponseEntity.ok().body("Admin profiles");
    }
}
