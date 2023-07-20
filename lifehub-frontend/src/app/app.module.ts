import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { HeaderComponent } from './components/usuario/header/header.component';
import { HomeComponent } from './pages/usuario/home/home.component';
import { ReceitasComponent } from './pages/usuario/controle-financeiro/receitas/receitas.component';
import { DespesasComponent } from './pages/usuario/controle-financeiro/despesas/despesas.component';
import { DashboardComponent } from './pages/usuario/controle-financeiro/dashboard/dashboard.component';
import { FooterComponent } from './components/usuario/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './shared/app-material/app-material.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    HomeComponent,
    ReceitasComponent,
    DespesasComponent,
    DashboardComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
