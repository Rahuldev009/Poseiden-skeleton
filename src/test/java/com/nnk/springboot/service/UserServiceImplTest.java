package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void getByIdUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("abc");
        user.setFullname("abcxyz");
        user.setPassword("P@assw0rd");
        user.setRole("ADMIN");
        Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
        User user1 = userService.getByIdUser(1);
        Assert.assertTrue(user1.getId() == 1);
    }

    @Test
    public void findByUsername() {
        User user = new User();
        user.setId(1);
        user.setUsername("abc");
        user.setFullname("abcxyz");
        user.setPassword("P@assw0rd");
        user.setRole("ADMIN");
        Mockito.when(userRepository.findByUsername("abc")).thenReturn(user);
        User user1 = userService.findByUsername("abc");
        Assert.assertTrue(user1.getId() == 1);
    }

    @Test
    public void getAllUser() {
        userService.getAllUser();
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void saveUser() {
        userService.saveUser(new User());
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void updateUser() {
        userService.updateUser(new User());
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("abc");
        user.setFullname("abcxyz");
        user.setPassword("P@assw0rd");
        user.setRole("ADMIN");
        Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
        userService.deleteUser(1);
        Mockito.verify(userRepository, Mockito.times(1)).delete(Mockito.any(User.class));
    }

}