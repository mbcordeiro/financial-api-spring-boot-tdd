package com.matheucordeiro.financialapi.entities;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProfileTest {
    @Test
    public void shouldCreateBuildProfileObject() {
        var profile = Profile.builder()
                .id(1L)
                .name("Matheus Cordeiro")
                .email("matheusdebarroscordeiro@gmail.com")
                .cpf("111111111111")
                .phone("9999999999")
                .build();

        assertThat(profile);
    }
}
