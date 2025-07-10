package com.example.demo.power;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PowerRepository extends JpaRepository<Power, Long> {
    Optional<Power> findPowerByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
