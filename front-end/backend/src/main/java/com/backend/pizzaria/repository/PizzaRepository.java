package com.backend.pizzaria.repository;

import com.backend.pizzaria.models.PizzasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<PizzasModel, Long> {

    @Query(nativeQuery = true, value = "" +
            "SELECT * FROM pizzas pz where pz.id = :id")
    PizzasModel getPizzaById(@Param("id") Long id);
}
