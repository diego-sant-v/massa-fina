package com.backend.pizzaria.dto;

public class PizzaDTO {
    private FileDTO fileDTO;
    private String  pizzaName;
    private String typePizza;
    private String edge;
    private String price;
    private String ingredients;

    public FileDTO getFileDTO() {
        return fileDTO;
    }

    public void setFileDTO(FileDTO fileDTO) {
        this.fileDTO = fileDTO;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(String typePizza) {
        this.typePizza = typePizza;
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
