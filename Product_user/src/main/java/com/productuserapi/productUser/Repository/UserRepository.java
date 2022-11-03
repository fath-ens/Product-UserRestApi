package com.productuserapi.productUser.Repository;

import com.productuserapi.productUser.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
