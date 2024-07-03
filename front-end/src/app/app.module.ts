import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './landing-pages/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CadastroComponent } from './sistema/components/cadastro/cadastro.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SidenavComponent } from './sistema/util/sidenav/sidenav.component';
import { UserHomeComponent } from './sistema/user/user-home/user-home.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { NavbarSystemComponent } from './sistema/util/navbar-system/navbar-system.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { MatIconModule } from '@angular/material/icon';
import { OrderComponent } from './sistema/user/order/order.component'
import { MatSelectModule } from '@angular/material/select';
import { AdminHomeComponent } from './sistema/admin/admin-home/admin-home.component';
import { ProductComponent } from './sistema/admin/product/product.component';
import { UploadImageModalComponent } from './sistema/util/upload-image-modal/upload-image-modal.component';






@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    CadastroComponent,
    SidenavComponent,
    UserHomeComponent,
    NavbarSystemComponent,
    OrderComponent,
    AdminHomeComponent,
    ProductComponent,
    UploadImageModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule,
    MatSnackBarModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    ButtonModule,
    CardModule,
    MatIconModule,
    MatSelectModule
  ],
  providers: [{ provide: MAT_DATE_LOCALE, useValue: 'pt-br' }],//muda a linguagem e o tipo de data do datepicker
  bootstrap: [AppComponent]
})
export class AppModule { }
