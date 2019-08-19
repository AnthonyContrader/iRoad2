import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [AdminLayoutComponent, AdminMenuComponent, HeaderComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }
