package com.backend.pizzaria.models;

import com.backend.pizzaria.enums.EdgesTypes;
import com.backend.pizzaria.enums.PizzaTypes;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pizzas")
public class PizzasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "pizza_name")
    private String pizzaName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_pizza")
    private PizzaTypes typePizza;

    @Enumerated(EnumType.STRING)
    @Column(name = "edge")
    private EdgesTypes edge;

    @Column(name = "price")
    private Float price;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public PizzaTypes getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(PizzaTypes typePizza) {
        this.typePizza = typePizza;
    }

    public EdgesTypes getEdge() {
        return edge;
    }

    public void setEdge(EdgesTypes edge) {
        this.edge = edge;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

}
