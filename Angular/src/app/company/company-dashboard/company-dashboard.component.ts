import { Component, OnInit } from '@angular/core';
import { CompanyDTO } from 'src/dto/companydto';

@Component({
  selector: 'app-company-dashboard',
  templateUrl: './company-dashboard.component.html',
  styleUrls: ['./company-dashboard.component.css']
})
export class CompanyDashboardComponent implements OnInit {

  company: CompanyDTO;
  constructor() { }

  ngOnInit() {
    this.company = JSON.parse(localStorage.getItem('currentUser'));
    
    
  }
}
