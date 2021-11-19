package com.matheucordeiro.financialapi.repositories;

import com.matheucordeiro.financialapi.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
