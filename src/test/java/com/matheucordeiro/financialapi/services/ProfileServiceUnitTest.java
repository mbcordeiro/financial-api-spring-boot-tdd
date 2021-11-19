package com.matheucordeiro.financialapi.services;

import com.matheucordeiro.financialapi.entities.Profile;
import com.matheucordeiro.financialapi.repositories.ProfileRepository;
import com.matheucordeiro.financialapi.services.impl.ProfileServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProfileServiceUnitTest {
    @TestConfiguration
    static class ProfileServiceTestConfiguration {
        @Bean
        public ProfileService profileService() {
            return new ProfileServiceImpl();
        }
    }

    @Autowired
    private ProfileService profileService;

    @MockBean
    private ProfileRepository profileRepository;

    @Before
    public void setUp() {
        var profiles  = buildProfilesFake();
        when(profileRepository.findAll()).thenReturn(profiles);
    }

    @Test
    public void shouldGetAllProfiles() {
        var profiles = buildProfilesFake();
        when(profileService.getAllProfiles()).thenReturn(profiles);
        assertThat(profiles).isNotNull().isNotEmpty();
    }

    private List<Profile> buildProfilesFake() {
        List<Profile> profiles = new ArrayList<>();
        var profileFirst = Profile.builder()
                .id(1L)
                .name("Matheus Cordeiro")
                .email("matheusdebarroscordeiro@gmail.com")
                .cpf("111111111111")
                .phone("9999999999")
                .build();

        var profileSecond = Profile.builder()
                .id(2L)
                .name("Karina Cordeiro")
                .email("karinacordeiro@gmail.com")
                .cpf("22222222222")
                .phone("9999999999")
                .build();

        profiles.add(profileFirst);
        profiles.add(profileSecond);

        return profiles;
    }
}
