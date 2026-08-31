package com.kadias.demospringboot.resources;

import com.kadias.demospringboot.entities.Order;
import com.kadias.demospringboot.services.OrderServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    private final OrderServices userServices;

    public OrderResource(OrderServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> users = userServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order user = userServices.findByID(id);
        return ResponseEntity.ok().body(user);

    }
}