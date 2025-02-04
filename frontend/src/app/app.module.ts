import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';

import { AccueilComponent } from './components/accueil/accueil.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { EtudiantsComponent } from './components/etudiants/etudiants.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { StagesComponent } from './components/stages/stages.component';
import { CandidatsComponent } from './components/candidats/candidats.component';
import { EntrepriseComponent } from './components/entreprise/entreprise.component';
import { ProfsComponent } from './components/profs/profs.component';
import { TuteursComponent } from './components/tuteurs/tuteurs.component';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    LoginComponent,
    RegisterComponent,
    SidebarComponent,
    EtudiantsComponent,
    DashboardComponent,
    StagesComponent,
    CandidatsComponent,
    EntrepriseComponent,
    ProfsComponent,
    TuteursComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
