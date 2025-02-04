import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { AccueilComponent } from './components/accueil/accueil.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EtudiantsComponent } from './components/etudiants/etudiants.component';
import { StagesComponent } from './components/stages/stages.component';
import { CandidatsComponent } from './components/candidats/candidats.component';
import { EntrepriseComponent } from './components/entreprise/entreprise.component';
import { ProfsComponent } from './components/profs/profs.component';
import { TuteursComponent } from './components/tuteurs/tuteurs.component';

const routes: Routes = [
  {path:'', redirectTo: 'accueil', pathMatch: 'full'},
  {path:'accueil', component: AccueilComponent},
  {path:'register', component: RegisterComponent},
  {path:'login', component: LoginComponent},
  {
    path:'dashboard', 
    component: DashboardComponent,
    children:[
      {path: '', redirectTo: 'stages', pathMatch: 'full'},
      {path:'etudiants', component: EtudiantsComponent},
      {path:'stages', component: StagesComponent},
      {path:'candidats', component: CandidatsComponent},
      {path:'entreprises', component: EntrepriseComponent},
      {path:'profs', component: ProfsComponent},
      {path:'tuteurs', component: TuteursComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }