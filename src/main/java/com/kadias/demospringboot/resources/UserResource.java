package com.kadias.demospringboot.resources;

import com.kadias.demospringboot.entities.User;
import com.kadias.demospringboot.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserServices userServices;

    public UserResource(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userServices.findByID(id);
        return ResponseEntity.ok().body(user);

    }
}