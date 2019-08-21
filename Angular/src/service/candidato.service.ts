import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { Observable } from 'rxjs';
import { AbstractCandidatoService } from './abstractcandidatoservice.service';


@Injectable({
  providedIn: 'root'
})
export class CandidatoService extends AbstractCandidatoService<CandidatoDTO>{
 

  constructor(http: HttpClient) {
    super(http);
    this.type = 'candidatoes';
    this.name= 'Micro2';
    this.port = '8080';
  }
  userLogged(username: string) {
     console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8080/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
   }

  readCandidato(id: number): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type + '/' + id, {
      headers: {
        Authorization: this.auth()
      }
    });
  }
}