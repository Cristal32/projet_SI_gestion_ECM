import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Tuteur } from '../models/tuteur';

@Injectable({
  providedIn: 'root'
})
export class TuteurService {

  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getTuteurs(): Observable<Tuteur[]>{
    return this.http.get<Tuteur[]>(`${this.apiServerUrl}/tuteur/getAll`);
  }

  //add tuteur
  public addTuteur(tuteur: Tuteur): Observable<Tuteur>{
    return this.http.post<Tuteur>(`${this.apiServerUrl}/tuteur/add`, tuteur);
  }

  //update tuteur
  public updateTuteur(tuteur: Tuteur): Observable<Tuteur>{
    return this.http.put<Tuteur>(`${this.apiServerUrl}/tuteur/update`, tuteur);
}

//delete tuteur
public deleteTuteur(tuteurId: number): Observable<void>{
  return this.http.delete<void>(`${this.apiServerUrl}/tuteur/delete/${tuteurId}`);
}
}
