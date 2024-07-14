import { Injectable } from '@angular/core';
import { UserRegisterDTO } from '../../models/user-register-dto';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { SnackBarService } from 'src/app/components/snack-bar/snack-bar.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiUrl = 'http://localhost:8080/auth';
  private isLogged = false;
  private tokenUser = "";
  constructor(private http: HttpClient, private snackBar: SnackBarService) { }
  registerUser(userRegister: UserRegisterDTO): Observable<any> {
    let apiUrlRegister = this.apiUrl + '/register'
    return this.http.post(apiUrlRegister, userRegister);
  }

  loginUser(email: string, password: string): Observable<UserRegisterDTO> {
    const apiUrlLogin = `${this.apiUrl}/signin`;
    const body = {
      email: email,
      password: password
    };

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.post<UserRegisterDTO>(apiUrlLogin, body, { headers });
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
