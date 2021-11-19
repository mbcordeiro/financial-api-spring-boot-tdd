package com.matheucordeiro.financialapi.services;

import com.matheucordeiro.financialapi.entities.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();

    Profile getProfileById(Long id);
}
