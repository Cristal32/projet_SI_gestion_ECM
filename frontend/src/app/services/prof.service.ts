import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Prof } from '../models/prof';

@Injectable({
  providedIn: 'root'
})
export class ProfService {

  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getProfs(): Observable<Prof[]>{
    return this.http.get<Prof[]>(`${this.apiServerUrl}/prof/getAll`);
  }

  //add prof
  public addProf(prof: Prof): Observable<Prof>{
    return this.http.post<Prof>(`${this.apiServerUrl}/prof/add`, prof);
  }

  //update prof
  public updateProf(prof: Prof): Observable<Prof>{
    return this.http.put<Prof>(`${this.apiServerUrl}/prof/update`, prof);
}

//delete prof
public deleteProf(profId: number): Observable<void>{
  return this.http.delete<void>(`${this.apiServerUrl}/prof/delete/${profId}`);
}
}
