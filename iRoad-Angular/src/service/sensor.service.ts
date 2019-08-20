import { SensorDTO } from 'src/dto/sensordto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AbstractSensorService } from './abstractsensorservice.service';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 */
@Injectable({
  providedIn: 'root'
})
export class SensorService extends AbstractSensorService<SensorDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'sensor';
    this.name= 'micro2';
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



  readSensor(id: number): Observable<any>{
    return this.http.get<any[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type  + '/'+ id, {
      headers: {
        Authorization : this.auth()
      }
    });
  }
}
