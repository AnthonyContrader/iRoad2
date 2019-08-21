import { Component, OnInit } from '@angular/core';
import { CompanyDTO } from 'src/dto/companydto';
import { CompanyService } from 'src/service/company.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  company: CompanyDTO[];
  companytoinsert: CompanyDTO = new CompanyDTO();

  constructor(private service: CompanyService) { }

  ngOnInit() {
    this.getCompany();
  }

  getCompany() {
    this.service.getAll().subscribe(company => this.company = company);
  }

  delete(company: CompanyDTO) {
    this.service.delete(company.id).subscribe(() => this.getCompany());
  }

  update(company: CompanyDTO) {
    this.service.update(company).subscribe(() => this.getCompany());
  }

}

