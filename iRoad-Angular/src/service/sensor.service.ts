import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { SensorDTO } from 'src/dto/sensordto';
import { HttpClient } from '@angular/common/http';


/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 */
@Injectable({
  providedIn: 'root'
})
export class SensorService extends AbstractService<SensorDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'sensor';
    this.port = '8080';
  }
}
