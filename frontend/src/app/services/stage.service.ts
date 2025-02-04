import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Stage } from '../models/stage';

@Injectable({providedIn: 'root'})

export class StageService {
  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getStages(): Observable<Stage[]>{
    return this.http.get<Stage[]>(`${this.apiServerUrl}/stage/getAll`);
  }

  //add stage
  public addStage(stage: Stage): Observable<Stage>{
    return this.http.post<Stage>(`${this.apiServerUrl}/stage/add`, stage);
  }

  //update stage
  public updateStage(stage: Stage): Observable<Stage>{
      return this.http.put<Stage>(`${this.apiServerUrl}/stage/update`, stage);
  }

  //delete stage
  public deleteStage(stageId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/stage/delete/${stageId}`);
  }

}
