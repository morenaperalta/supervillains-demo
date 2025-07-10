package com.example.demo.supervillain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervillainRepository extends JpaRepository<Supervillain, Long> {
    Optional<Supervillain> findSupervillainByNameIgnoreCase(String name);
    Optional<Supervillain> findSupervillainByAliasIgnoreCase(String alias);
    boolean existsByNameIgnoreCase(String name);
    boolean existsByAliasIgnoreCase(String alias);
    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);
    boolean existsByAliasIgnoreCaseAndIdNot(String alias, Long id);
}
