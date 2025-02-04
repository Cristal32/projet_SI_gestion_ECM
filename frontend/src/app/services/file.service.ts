import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { FileData } from '../models/fileData';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public uploadFile(fileForm: FormData): Observable<string> {
    return this.http.request('post', `${this.apiServerUrl}/file/upload`, {
      body: fileForm,
      responseType: 'text' // Set the responseType to 'text'
    });
  }

  public downloadFile(filename: string): Observable<Blob>{
    return this.http.get(`${this.apiServerUrl}/file/download/${filename}`, { responseType: 'blob' });
  }

  //get a file by its fileName
  public getFileByFileName(filename: string): Observable<FileData>{
    return this.http.get<FileData>(`${this.apiServerUrl}/file/getByFileName/${filename}`)
  }
}
