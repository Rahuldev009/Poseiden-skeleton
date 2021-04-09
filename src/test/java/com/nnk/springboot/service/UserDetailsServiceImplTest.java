package com.nnk.springboot.service;

import com.nnk.springboot.domain.CustomUserDetails;
import com.nnk.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceImplTest {
    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Mock
    UserService userService;

    @Test
    public void loadUserByUsername() {
        User user = new User();
        user.setId(1);
        user.setUsername("abc");
        user.setFullname("abcxyz");
        user.setPassword("P@assw0rd");
        user.setRole("ADMIN");
        Mockito.when(userService.findByUsername("abc")).thenReturn(user);
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsService.loadUserByUsername("abc");
        assertEquals("abc", customUserDetails.getUsername());
    }

}