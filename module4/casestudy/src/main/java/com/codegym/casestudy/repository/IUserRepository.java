package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
