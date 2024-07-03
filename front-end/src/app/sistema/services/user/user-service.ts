import { Injectable } from '@angular/core';
import { UserRegisterDTO } from '../../models/user-register-dto';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { SnackBarService } from 'src/app/components/snack-bar/snack-bar.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiUrl = 'http://localhost:8080/api/auth';
  private isLogged = false;
  private tokenUser = "";
  constructor(private http: HttpClient, private snackBar: SnackBarService) { }
  registerUser(userRegister: UserRegisterDTO): Observable<any> {
    let apiUrlRegister = this.apiUrl + '/register'
    return this.http.post(apiUrlRegister, userRegister);
  }

  loginUser(login: string, password: string): Observable<UserRegisterDTO> {
    const apiUrlLogin = `${this.apiUrl}/login`;
    const body = { login, password }; // Objeto com os dados de login
    return this.http.post<any>(apiUrlLogin, body);
  }

  setUserAccountLogged(user:UserRegisterDTO){
    localStorage.setItem('currentUser', JSON.stringify(user));
    this.isLogged = true;
    console.log('noSetUserAccount', JSON.stringify(user))
    this.tokenUser = user.token;
  }

  setUserAccountLogout(){
    localStorage.removeItem('currentUser');
    this.isLogged = false;
  }

  getCurrentUser(){
    const storedUser = localStorage.getItem('currentUser');
    if (storedUser) {
      this.isLogged = true;
      const parsedUser: UserRegisterDTO = JSON.parse(storedUser);
      this.tokenUser = parsedUser.token;
      return parsedUser;
    }else{
      return this.snackBar.openSnackBar("usuário não encontrado, logue novamente", "X")
    }
  }

  isLoggedIn(): any {
    return this.isLoggedIn;
  }

  getTokenUser(){
    console.log('no get token user')
    return this.tokenUser;
  }
}
