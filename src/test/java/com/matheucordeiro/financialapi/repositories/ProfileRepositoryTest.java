package com.matheucordeiro.financialapi.repositories;

import com.matheucordeiro.financialapi.entities.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProfileRepository profileRepository;

    @Test
    public void givenACorrectSetupThenAnEntityManagerWillBeAvailable() {
        assertNotNull(entityManager);
    }

    @Test
    public void shouldFindAllProfiles() {
        var profile = buildProfileFake();
        entityManager.persist(profile);
        var profiles = profileRepository.findAll();
        Assertions.assertNotNull(profiles);
    }

    private Profile buildProfileFake() {
        return Profile.builder()
                .id(1L)
                .name("Matheus Cordeiro")
                .email("matheusdebarroscordeiro@gmail.com")
                .cpf("111111111111")
                .phone("9999999999")
                .build();
    }
}
