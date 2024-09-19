package com.sathwik.shopspring.repository;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathwik.shopspring.enums.UserRole;
import com.sathwik.shopspring.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    // Only Used to check of ADMIN exists (running for first time)
    Optional<User> findByRole(UserRole userRole);

}