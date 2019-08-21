import { Component, OnInit } from '@angular/core';
import { CandidatoDTO } from 'src/dto/candidatodto';

@Component({
  selector: 'app-candidato-dashboard',
  templateUrl: './candidato-dashboard.component.html',
  styleUrls: ['./candidato-dashboard.component.css']
})
export class CandidatoDashboardComponent implements OnInit {
  candidato: CandidatoDTO;
  constructor() { }

  ngOnInit() {
    this.candidato = JSON.parse(localStorage.getItem('currentUser'));


  }
}
