import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Etudiant } from '../models/etudiant';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getEtudiants(): Observable<Etudiant[]>{
    return this.http.get<Etudiant[]>(`${this.apiServerUrl}/etudiant/getAll`);
  }

  //add etudiant
  public addEtudiant(etudiant: Etudiant): Observable<Etudiant>{
    return this.http.post<Etudiant>(`${this.apiServerUrl}/etudiant/add`, etudiant);
  }

  //update etudiant
  public updateEtudiant(etudiant: Etudiant): Observable<Etudiant>{
      return this.http.put<Etudiant>(`${this.apiServerUrl}/etudiant/update`, etudiant);
  }

  //delete stage
  public deleteEtudiant(etudiantId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/etudiant/delete/${etudiantId}`);
  }

}
