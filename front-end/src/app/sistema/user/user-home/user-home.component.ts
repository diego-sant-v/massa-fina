import { Component } from '@angular/core';
import { PizzaServiceService } from '../../services/pizza/pizza-service.service';
import { PizzaRegisterDTO } from '../../models/pizza-register-dto';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.scss']
})
export class UserHomeComponent {
    pizzasObj: PizzaRegisterDTO[] = [];//crio uma variavel pizzasObj que é do tipo PizzaRegisterDTO[] e vai comecar = []
    //dai não preciso fazer um outro objeto com cada propriedade de PizzaRegisterDTO e atribuir
    constructor(private pizzaService: PizzaServiceService){}
    ngOnInit(): void {
      //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
      //Add 'implements OnInit' to the class.
      this.getAllPizza();
    }

    getAllPizza(){
      this.pizzaService.getAllPizza().subscribe({
        next:(result: PizzaRegisterDTO[]) => {
          this.pizzasObj = result;
          console.log('no result', this.pizzasObj)
        },
        error:(error: any) => {
          console.log('error', error)
        }
      })
    }
}
