import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isCandidatoCollapsed = false;
  isCompanyCollapsed = false;
  isOpenjobCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  candidatocollapse() {
    if (this.isCandidatoCollapsed === false) {
      this.isCandidatoCollapsed = true;
    } else { this.isCandidatoCollapsed = false; }
  }

  companycollapse() {
    if (this.isCompanyCollapsed === false) {
      this.isCompanyCollapsed = true;
    } else { this.isCompanyCollapsed = false; }
  }

  openjobcollapse() {
    if (this.isOpenjobCollapsed === false) {
      this.isOpenjobCollapsed = true;
    } else { this.isOpenjobCollapsed = false; }
  }
}
