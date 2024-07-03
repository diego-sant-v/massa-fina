import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserService } from '../user/user-service';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {
  private uploadUrl = 'http://localhost:8080/api/file/v1/uploadFile'; // Endereço do seu endpoint
  token: string = '';
  constructor(private http: HttpClient, private userService: UserService) { }

  uploadFile(file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    this.getToken()
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    return this.http.post<any>(this.uploadUrl, formData, { headers });
  }

  getToken(){
    this.token = this.userService.getTokenUser();
  }
}
