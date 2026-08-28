package com.kadias.demospringboot.config;

import com.kadias.demospringboot.entities.User;
import com.kadias.demospringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements org.springframework.boot.CommandLineRunner {
   @Autowired
   private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456");
        User u2 = new User(null, "Alex Green", "Alexgreen@gmail.com", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
