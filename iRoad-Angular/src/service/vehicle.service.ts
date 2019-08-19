import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { VehicleDTO } from 'src/dto/vehicledto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService extends AbstractService<VehicleDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'vehicle';
    this.port = '8080'
  }
}
