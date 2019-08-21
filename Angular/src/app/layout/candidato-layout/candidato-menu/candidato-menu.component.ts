import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidato-menu',
  templateUrl: './candidato-menu.component.html',
  styleUrls: ['./candidato-menu.component.css']
})
export class CandidatoMenuComponent implements OnInit {

  isProfilocandidatoCollapsed = false;
  isQuestionaryCollapsed = false;
  

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  profilocandidatocollapse() {
    if (this.isProfilocandidatoCollapsed === false) {
      this.isProfilocandidatoCollapsed = true;
    } else { this.isProfilocandidatoCollapsed = false; }
  }

  questionarycollapse() {
    if (this.isQuestionaryCollapsed === false) {
      this.isQuestionaryCollapsed = true;
    } else { this.isQuestionaryCollapsed = false; }
  }
}
