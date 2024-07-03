import { Component } from '@angular/core';
import { PizzaRegisterDTO } from '../../models/pizza-register-dto';
import { PizzaServiceService } from '../../services/pizza/pizza-service.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent {
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
        console.log('no result', this.pizzasObj, this.pizzasObj)
      },
      error:(error: any) => {
        console.log('error', error)
      }
    })
  }
}
