import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company-menu',
  templateUrl: './company-menu.component.html',
  styleUrls: ['./company-menu.component.css']
})
export class CompanyMenuComponent implements OnInit {

  isProfilocompanyCollapsed = false;
  isOpenjobcompanyCollapsed = false;
  

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  profilocompanycollapse() {
    if (this.isProfilocompanyCollapsed === false) {
      this.isProfilocompanyCollapsed = true;
    } else { this.isProfilocompanyCollapsed = false; }
  }

  openjobcompanycollapse() {
    if (this.isOpenjobcompanyCollapsed === false) {
      this.isOpenjobcompanyCollapsed = true;
    } else { this.isOpenjobcompanyCollapsed = false; }
  }
}
