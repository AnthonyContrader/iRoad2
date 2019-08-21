import { Component, OnInit } from '@angular/core';
import { OpenjobDTO } from 'src/dto/openjobdto';
import { OpenjobService } from 'src/service/openjob.service';

@Component({
  selector: 'app-openjob-company',
  templateUrl: './openjob-company.component.html',
  styleUrls: ['./openjob-company.component.css']
})
export class OpenjobCompanyComponent implements OnInit {
  list: OpenjobDTO[];
  openjobtoinsert: OpenjobDTO = new OpenjobDTO();
  companyId: number;

  constructor(private service: OpenjobService) { }

  ngOnInit() {
    this.getList();
    //this.companyId= JSON.parse(localStorage.getItem("companyId"));
    //this.readOpenjob(this.companyId);
  }
  getList() {
    this.service.getAll().subscribe(list => this.list = list);
  }
 
  insert(openjob: OpenjobDTO) {
    this.service.insert(openjob).subscribe(()=> this.list);
  }

  readOpenjob(companyId: number) {
    this.service.readOpenjob(companyId).subscribe(list => this.list =list);
  }

  delete(openjob: OpenjobDTO) {
    this.service.delete(openjob.id).subscribe(() => this.list);
  }

  update(openjob: OpenjobDTO) {
    this.service.update(openjob).subscribe(() => this.list);
  }

  clear(){
    this.openjobtoinsert = new OpenjobDTO();
  }
}
