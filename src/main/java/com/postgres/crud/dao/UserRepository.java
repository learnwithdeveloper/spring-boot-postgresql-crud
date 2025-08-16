package com.postgres.crud.dao;

import com.postgres.crud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
