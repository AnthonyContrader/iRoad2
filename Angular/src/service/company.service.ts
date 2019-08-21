import { CompanyDTO } from 'src/dto/companydto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AbstractCompanyService } from './abstractcompanyservice.service';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends AbstractCompanyService<CompanyDTO>{
 
  constructor(http: HttpClient) {
    super(http);
    this.type = 'companies';
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



  readCompany(id: number): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type  + '/'+ id, {
      headers: {
        Authorization : this.auth()
      }
    });
  }
}