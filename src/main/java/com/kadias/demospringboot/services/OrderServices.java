package com.kadias.demospringboot.services;

import com.kadias.demospringboot.entities.Order;
import com.kadias.demospringboot.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {
    private final OrderRepository userRepository;

    public OrderServices(OrderRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Order> findAll() {
        return userRepository.findAll();
    }

    public Order findByID(Long id) {
        Optional<Order> obj = userRepository.findById(id);
        return obj.get();
    }
}
