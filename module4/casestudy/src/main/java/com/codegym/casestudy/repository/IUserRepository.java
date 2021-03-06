package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "insert into user_role (user_id, role_id) values (:user_id, :role_id)", nativeQuery = true)
    void addUserRole(@Param("user_id") Long user_id, @Param("role_id") Long role_id);

    @Modifying
    @Transactional
    @Query(value = "insert into user_role (user_id, role_id) values (:user_id, :role_id_1), (:user_id, :role_id_2)", nativeQuery = true)
    void addUserRoleMultiple(@Param("user_id") Long user_id, @Param("role_id_1") Long role_id_1, @Param("role_id_1") Long role_id_2);
}
