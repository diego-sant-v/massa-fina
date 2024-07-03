import { Component } from '@angular/core';
import { UserRegisterDTO } from '../../models/user-register-dto';
import { UserService } from '../../services/user/user-service';
import { ViaCepService } from './via_cep/via-cep.service';
import { formatDate } from '@angular/common';
import { SnackBarService } from 'src/app/components/snack-bar/snack-bar.service';
import { Router } from '@angular/router';
import { ViaCepDTO } from './via_cep/via-cep-dto';
import { RoleTypeEnum } from '../../enums/RoleTypeEnum';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent {
  viaCepDto: ViaCepDTO[] = []; 
  roles: string[] = Object.values(RoleTypeEnum).map(value => String(value));
  roleSelected = "";
  userDto: UserRegisterDTO = new UserRegisterDTO();
  loginSigin = "";
  passwordSigin = "";
  repeatPassword = "";
  cep = "";
  constructor(private userService: UserService, private viaCepServie: ViaCepService, private matSnackBar: SnackBarService,
    private router: Router) {
    //this.dateOfBirth = new Date().toISOString();
  }

  consultarCep(cep: string) {
    if(cep){
      this.viaCepServie.findInformationsCep(cep).subscribe({
        next: (informations: ViaCepDTO) => {
          console.log('Informações do cep:', informations);
          this.populateCepInUser(informations)
        },
        error:(error: any) => {
          console.log('Erro ao consultar cep', error);
        }
      });
    }else{
      return
    }
  }

  populateCepInUser(informations: ViaCepDTO){
    console.log(typeof(informations), informations)
      this.userDto.locality = informations.localidade;
      this.userDto.complement = informations.complemento;
      this.userDto.cep = informations.cep;
      this.userDto.dd = informations.ddd;
      this.userDto.neighborhood = informations.bairro;
      this.userDto.street = informations.logradouro;
      this.userDto.uf = informations.uf;
      console.log(typeof(informations), informations)
  }

  register() {
    this.userDto.dateOfBirth = "1990-01-01"
    this.userService.registerUser(this.userDto).subscribe({
      next: (result) => {
        console.log('Usuário registrado com sucesso', result);
        this.matSnackBar.openSnackBar("Usuário salvo com sucesso", "X")
      },
      error:(error: any) => {
        console.log('erro ao registrar usuário', error);
      }
    });
  }

  login(){
    this.userService.loginUser(this.loginSigin, this.passwordSigin).subscribe({
      next: (result: UserRegisterDTO) => {
        console.log('no result', result)
        this.userService.setUserAccountLogged(result)
        this.loadHomeSistemByTipeUser(result.role)
        this.matSnackBar.openSnackBar(`Bem vindo, ${result.userName}`, "X")
      },
      error:(error: any) => {
        console.log('erro ao registrar usuário', error);
      }
    });
  }

  loadHomeSistemByTipeUser(role: String){
    this.router.navigate(['user/user-home']);
    if(role == "ADMIN"){
      this.router.navigate(['admin/admin-home']);
    }else{
      this.router.navigate(['user/user-home']);
    }
  }

}
