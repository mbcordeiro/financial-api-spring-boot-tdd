package com.matheucordeiro.financialapi.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test public void shouldProfileObjectNull() {
        var profile = new Profile();
        assertEquals(new Profile(), profile);
    }
}
