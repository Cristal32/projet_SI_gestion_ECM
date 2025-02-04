import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Candidat } from '../models/candidat';

@Injectable({
  providedIn: 'root'
})
export class CandidatService {

  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getCandidats(): Observable<Candidat[]>{
    return this.http.get<Candidat[]>(`${this.apiServerUrl}/candidat/getAll`);
  }

  //add candidat
  public addCandidat(candidat: Candidat): Observable<Candidat>{
    return this.http.post<Candidat>(`${this.apiServerUrl}/candidat/add`, candidat);
  }

  //add candidat with dossier
  public addCandidatWithDossier(candidat : Candidat, dossier: File): Observable<any>{
    const formData = new FormData();
    formData.append('dossier', dossier);

    console.log(formData);
    console.log(dossier.name);

    const candidatJson = JSON.stringify(candidat);
    formData.append('candidatData', new Blob([candidatJson], { type: 'application/json' }));

    return this.http.request('post', `${this.apiServerUrl}/candidat/addCandidatWithDossier`, {
      body: formData,
      responseType: 'text'
    });
  }

  //update candidat
  public updateCandidat(candidat : Candidat): Observable<Candidat>{
      return this.http.put<Candidat>(`${this.apiServerUrl}/candidat/update`, candidat);
  }

  //delete candidat
  public deleteCandidat(candidatEmail: string): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/candidat/delete/${candidatEmail}`);
  }
}
