package com.matheucordeiro.financialapi.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProfileServiceUnitTest {
    @Autowired
    private ProfileService profileService;
}
