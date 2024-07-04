package com.backend.pizzaria.repository;

import com.backend.pizzaria.models.UsersModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM users u where u.id = :id")
    UsersModel getUserById(@Param("id") Long id);

    @Query("SELECT u FROM UsersModel u WHERE u.userName = :userName")
    UsersModel findByUsername(@Param("userName") String userName);

    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM users u where u.email = :email")
    UsersModel findByEmail(@Param("email") String email);

    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM users u where u.email = :email AND u.password = :password")
    UsersModel userLogin(@Param("email") String email, @Param("password") String password);
}
