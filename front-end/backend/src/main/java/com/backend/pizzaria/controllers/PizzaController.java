package com.backend.pizzaria.controllers;

import com.backend.pizzaria.models.PizzasModel;
import com.backend.pizzaria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pizza")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;
    @GetMapping("/all")
    public List<PizzasModel> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    @PostMapping("/create")
    public PizzasModel createPizza(@RequestBody PizzasModel pizzasModel){
        return pizzaRepository.save(pizzasModel);
    }
}
