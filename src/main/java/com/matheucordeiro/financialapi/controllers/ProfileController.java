package com.matheucordeiro.financialapi.controllers;

import com.matheucordeiro.financialapi.entities.Profile;
import com.matheucordeiro.financialapi.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/financial")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/profiles")
    private ResponseEntity<List<Profile>> getAllProfiles() {
        var list = profileService.getAllProfiles();
        return ResponseEntity.ok(list);
    }
}
