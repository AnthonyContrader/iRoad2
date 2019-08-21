import { Component, OnInit } from '@angular/core';
import { OpenjobDTO } from 'src/dto/openjobdto';
import { OpenjobService } from 'src/service/openjob.service';

@Component({
  selector: 'app-openjob',
  templateUrl: './openjob.component.html',
  styleUrls: ['./openjob.component.css']
})
export class OpenjobComponent implements OnInit {
  openjob: OpenjobDTO[];
  openjobtoinsert: OpenjobDTO = new OpenjobDTO;

  constructor(private service: OpenjobService) { }

  ngOnInit() {
    this.getOpenjob();
  }
  getOpenjob() {
    this.service.getAll().subscribe(openjob => this.openjob = openjob);
  }

  delete(openjob: OpenjobDTO) {
    this.service.delete(openjob.id).subscribe(() => this.getOpenjob());
  }

  update(openjob: OpenjobDTO) {
    this.service.update(openjob).subscribe(() => this.getOpenjob());
  }
}
