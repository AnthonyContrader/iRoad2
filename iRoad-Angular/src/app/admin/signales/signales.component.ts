import { Component, OnInit } from '@angular/core';
import { SignaleService } from 'src/service/signale.service';
import { SignaleDTO } from 'src/dto/signaledto';

@Component({
  selector: 'app-signales',
  templateUrl: './signales.component.html',
  styleUrls: ['./signales.component.css']
})
export class SignalesComponent implements OnInit {

  signales: SignaleDTO[];
  signaletoinsert: SignaleDTO = new SignaleDTO();

  constructor(private service: SignaleService) { }

  ngOnInit() {
    this.getSignales();
  }

  getSignales() {
    this.service.getAll().subscribe(signales => this.signales = signales);
  }

  delete(signale: SignaleDTO) {
    this.service.delete(signale.idSignale).subscribe(() => this.getSignales());
  }

  update(signale: SignaleDTO) {
    this.service.update(signale).subscribe(() => this.getSignales());
  }

  insert(signale: SignaleDTO) {
    this.service.insert(signale).subscribe(() => this.getSignales());
  }

  clear(){
    this.signaletoinsert = new SignaleDTO();
  }
}
