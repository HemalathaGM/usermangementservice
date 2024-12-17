package com.tekarch.usermangementservice.Repositories;

import com.tekarch.usermangementservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
