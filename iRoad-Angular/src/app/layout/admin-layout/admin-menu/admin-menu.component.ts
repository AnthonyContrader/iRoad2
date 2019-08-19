import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isVehicleCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isStreetCollapsed = false; 
  isSensorCollapsed = false;
  isSignaleCollapsed = false;
  isScreenCollapsed = false;

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
  vehiclescollapse() {
    if (this.isVehicleCollapsed === false) {
      this.isVehicleCollapsed = true;
    } else { this.isVehicleCollapsed = false; }
  }
  streetscollapse() {
    if (this.isStreetCollapsed === false) {
      this.isStreetCollapsed = true;
    } else { this.isStreetCollapsed = false; }
  }
  sensorscollapse() {
    if (this.isSensorCollapsed === false) {
      this.isSensorCollapsed = true;
    } else { this.isSensorCollapsed = false; }
  }
  signalescollapse() {
    if (this.isSignaleCollapsed === false) {
      this.isSignaleCollapsed = true;
    } else { this.isSignaleCollapsed = false; }
  }
  screenscollapse() {
    if (this.isScreenCollapsed === false) {
      this.isScreenCollapsed = true;
    } else { this.isScreenCollapsed = false; }
  }
  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
