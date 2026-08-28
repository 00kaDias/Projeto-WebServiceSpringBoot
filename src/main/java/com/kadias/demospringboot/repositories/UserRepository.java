package com.kadias.demospringboot.repositories;

import com.kadias.demospringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
