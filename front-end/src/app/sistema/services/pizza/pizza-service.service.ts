import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PizzaRegisterDTO } from '../../models/pizza-register-dto';
import { UserService } from '../user/user-service';

@Injectable({
  providedIn: 'root'
})
export class PizzaServiceService {
  private api_url = 'http://localhost:8080/api/pizza';
  private headers = new HttpHeaders();
  constructor(private http: HttpClient, private userService: UserService) {
  }

  getAllPizza(): Observable<PizzaRegisterDTO[]> {
    this.getTokenUser();
    const getAllPizzasUrl = `${this.api_url}/all`;
    console.log('token preenchido', this.headers)
    return this.http.get<PizzaRegisterDTO[]>(getAllPizzasUrl, { headers: this.headers, responseType: 'json' });
  }

  getTokenUser(){
    // Configuração dos cabeçalhos com o token de autorização
    const token = this.userService.getTokenUser();
    console.log('token preenchido', token)
    this.headers = this.headers.set('Authorization', `Bearer ${token}`);
  }
}
