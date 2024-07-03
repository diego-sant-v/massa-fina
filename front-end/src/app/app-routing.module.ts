import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './landing-pages/home/home.component';
import { CadastroComponent } from './sistema/components/cadastro/cadastro.component';
import { UserHomeComponent } from './sistema/user/user-home/user-home.component';
import { AdminHomeComponent } from './sistema/admin/admin-home/admin-home.component';
import { ProductComponent } from './sistema/admin/product/product.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'user/user-home', component: UserHomeComponent},
  {path: 'admin/admin-home', component: AdminHomeComponent},
  {path: 'admin/admin-product', component: ProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
