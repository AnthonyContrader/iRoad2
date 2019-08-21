import { Component, OnInit } from '@angular/core';
import { CandidatoDTO } from 'src/dto/candidatodto';
import { CandidatoService } from 'src/service/candidato.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profilocandidato',
  templateUrl: './profilocandidato.component.html',
  styleUrls: ['./profilocandidato.component.css']
})
export class ProfilocandidatoComponent implements OnInit {
  candidato: CandidatoDTO;
  candidatotoinsert: CandidatoDTO = new CandidatoDTO();
  id: number;
  router: Router;

  constructor(private service: CandidatoService) { }

  ngOnInit() {
    this.candidato = JSON.parse(localStorage.getItem('currentUser'));
    this.readCandidato(this.candidato.id);
  }

  readCandidato(id: number) {
    this.service.readCandidato(id).subscribe(candidato => this.candidato = candidato);
  }

  delete(candidato: CandidatoDTO) {
    this.service.delete(candidato.id).subscribe(() => this.readCandidato);
  }

  update(candidato: CandidatoDTO) {
    this.service.update(candidato).subscribe(() => this.readCandidato);
  }

  clear(){
    this.candidatotoinsert = new CandidatoDTO();
  }
}
