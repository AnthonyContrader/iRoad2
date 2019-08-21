import { Component, OnInit } from '@angular/core';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { CandidatoService } from 'src/service/candidato.service';

@Component({
  selector: 'app-candidato',
  templateUrl: './candidato.component.html',
  styleUrls: ['./candidato.component.css']
})
export class CandidatoComponent implements OnInit {
  candidato: CandidatoDTO[];
  candidatotoinsert: CandidatoDTO = new CandidatoDTO();

  constructor(private service: CandidatoService) { }

  ngOnInit() {
    this.getCandidato();
  }
  

  getCandidato() {
    this.service.getAll().subscribe(candidato => this.candidato = candidato);
  }

  delete(candidato: CandidatoDTO) {
    this.service.delete(candidato.id).subscribe(() => this.getCandidato());
  }

  update(candidato: CandidatoDTO) {
    this.service.update(candidato).subscribe(() => this.getCandidato());
  }

}
