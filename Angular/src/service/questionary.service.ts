import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AbstractCandidatoService } from './abstractcandidatoservice.service';
import { QuestionaryDTO } from 'src/dto/questionarydto';


@Injectable({
  providedIn: 'root'
})
export class QuestionaryService extends AbstractCandidatoService<QuestionaryDTO>{
 

  constructor(http: HttpClient) {
    super(http);
    this.type = 'questionary';
    this.name= 'Micro2';
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

  readQuestionary(id: number): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/questionaries' + id, {
      headers: {
        Authorization: this.auth()
      }
    });
  }
}