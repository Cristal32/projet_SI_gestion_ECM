import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { TypeStage } from '../models/typeStage';
@Injectable({
  providedIn: 'root'
})
export class TypeStageService {

  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getTypesStage(): Observable<TypeStage[]>{
    return this.http.get<TypeStage[]>(`${this.apiServerUrl}/typeStage/getAll`);
  }
}