package com.ecommerce.smartecommerce.repository;

import com.ecommerce.smartecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}