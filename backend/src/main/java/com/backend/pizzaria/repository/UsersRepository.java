package com.backend.pizzaria.repository;

import com.backend.pizzaria.user.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM users u where u.id = :id")
    UsersModel getUserById(@Param("id") Long id);

    UserDetails findByLogin(String login);
}
