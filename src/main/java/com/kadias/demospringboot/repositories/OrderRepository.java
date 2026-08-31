package com.kadias.demospringboot.repositories;

import com.kadias.demospringboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
