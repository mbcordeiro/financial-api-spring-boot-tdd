package com.matheucordeiro.financialapi.services.impl;

import com.matheucordeiro.financialapi.entities.Profile;
import com.matheucordeiro.financialapi.repositories.ProfileRepository;
import com.matheucordeiro.financialapi.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
