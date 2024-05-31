package com.example.caloriecraft.repository;

import com.example.caloriecraft.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
