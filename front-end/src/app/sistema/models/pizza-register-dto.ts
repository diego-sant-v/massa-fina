import { EdgePizzaEnum } from "../enums/EdgePizzaEnum";
import { TypePizzaEnum } from "../enums/TypePizzaEnum";
import { FilesDTO } from "./files-dto";

export class PizzaRegisterDTO {
    public pizzaName: string;
    public typePizza: TypePizzaEnum;
    public edge: EdgePizzaEnum;
    public price: number;
    public ingredients: string;
    public file: FilesDTO

    constructor(typePizza: TypePizzaEnum, edge: EdgePizzaEnum, price: number, ingredients: string, pizzaName: string, file: FilesDTO) {
        this.pizzaName = pizzaName
        this.typePizza = typePizza;
        this.edge = edge;
        this.price = price;
        this.ingredients = ingredients;
        this.file = file;
    }
}
