package com.matheucordeiro.financialapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheucordeiro.financialapi.entities.Profile;
import com.matheucordeiro.financialapi.services.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProfileControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProfileService profileService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldGetAllProfiles() throws Exception {
        var profiles = buildProfilesFake();

        when(profileService.getAllProfiles()).thenReturn(profiles);

        mockMvc.perform(get("/api/financial/profiles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(profiles)));
    }

    @Test
    public void shouldGetProfileById() throws Exception {
        var profile = buildProfileFake();

        when(profileService.getProfileById(1L)).thenReturn(profile);

        mockMvc.perform(get("/api/financial/profile/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(profile)));
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
