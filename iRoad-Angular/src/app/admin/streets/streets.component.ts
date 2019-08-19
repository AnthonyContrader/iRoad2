import { Component, OnInit } from '@angular/core';
import { StreetService } from 'src/service/street.service';
import { StreetDTO } from 'src/dto/streetdto';

@Component({
  selector: 'app-streets',
  templateUrl: './streets.component.html',
  styleUrls: ['./streets.component.css']
})
export class StreetsComponent implements OnInit {

  streets: StreetDTO[];
  streettoinsert: StreetDTO = new StreetDTO();

  constructor(private service: StreetService) { }

  ngOnInit() {
    this.getStreets();
  }

  getStreets() {
    this.service.getAll().subscribe(streets => this.streets = streets);
  }

  delete(street: StreetDTO) {
    this.service.delete(street.idstreet).subscribe(() => this.getStreets());
  }

  update(street: StreetDTO) {
    this.service.update(street).subscribe(() => this.getStreets());
  }

  insert(street: StreetDTO) {
    this.service.insert(street).subscribe(() => this.getStreets());
  }

  clear(){
    this.streettoinsert = new StreetDTO();
  }
}
