import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { SignaleDTO } from 'src/dto/signaledto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * 
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class SignaleService extends AbstractService<SignaleDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'signale';
    this.port = '8080';
  }

  

}
