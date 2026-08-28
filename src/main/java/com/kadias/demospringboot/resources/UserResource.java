package com.kadias.demospringboot.resources;

import com.kadias.demospringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping()
    public ResponseEntity<User> findAll() {

        User u = new User(1L, "Joao", "Joao@gmail.com", "12321");
        return ResponseEntity.ok().body(u);
    }
  @PostMapping("")
    public String lennaBoa(@RequestBody User body) {
        return "Lenna Boa" + body.getName();
    }
}