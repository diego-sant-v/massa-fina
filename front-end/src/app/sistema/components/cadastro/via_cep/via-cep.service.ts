import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ViaCepDTO } from './via-cep-dto';

@Injectable({
  providedIn: 'root'
})
export class ViaCepService {
  apiUrlViaCep = 'https://viacep.com.br/ws/';
  
  constructor(private http: HttpClient) { }
  
  findInformationsCep(cepParam: string): Observable<ViaCepDTO> {
    const apiUrl = `${this.apiUrlViaCep}${cepParam}/json/`;
    return this.http.get<ViaCepDTO>(apiUrl, {responseType: 'json'})
  }
}
