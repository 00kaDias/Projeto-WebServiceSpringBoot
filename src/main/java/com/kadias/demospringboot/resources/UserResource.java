package com.kadias.demospringboot.resources;

import com.kadias.demospringboot.entities.User;
import com.kadias.demospringboot.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public  ResponseEntity<User> insert(@RequestBody User user) {
       user = userServices.insert(user);

       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(user.getId())
               .toUri();

        return ResponseEntity.created(uri).body(user);
    }

   @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}