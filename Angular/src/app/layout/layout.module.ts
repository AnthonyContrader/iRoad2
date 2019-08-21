import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { CompanyLayoutComponent } from './company-layout/company-layout.component';
import { CandidatoMenuComponent } from './candidato-layout/candidato-menu/candidato-menu.component';
import { CompanyMenuComponent } from './company-layout/company-menu/company-menu.component';
import { CandidatoLayoutComponent } from './candidato-layout/candidato-layout.component';

/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi 
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 */
@NgModule({
  declarations: [AdminLayoutComponent, AdminMenuComponent, HeaderComponent,  CandidatoLayoutComponent, CompanyLayoutComponent, CandidatoMenuComponent, CompanyMenuComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }
