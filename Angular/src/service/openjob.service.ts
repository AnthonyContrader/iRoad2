import { AbstractCompanyService } from './abstractcompanyservice.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OpenjobDTO } from 'src/dto/openjobdto';

@Injectable({
  providedIn: 'root'
})
export class OpenjobService extends AbstractCompanyService<OpenjobDTO>{
 
  constructor(http: HttpClient) {
    super(http);
    this.type = 'openjobs';
    this.name= 'Micro1';
    this.port = '8080';
  }

  userLogged(username: string) {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8080/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
   }
 

  readOpenjob(companyId: number): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type + '/' + companyId, {
      headers: {
        Authorization: this.auth()
      }
    });
  }
}
