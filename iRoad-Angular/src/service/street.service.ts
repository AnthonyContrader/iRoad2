import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StreetDTO} from 'src/dto/streetdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class StreetService extends AbstractService<StreetDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'Street';
    this.port = '8080';
  }
}