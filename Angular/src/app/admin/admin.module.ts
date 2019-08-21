import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { CandidatoComponent } from './candidato/candidato.component';
import { CompanyComponent } from './company/company.component';
import { OpenjobComponent } from './openjob/openjob.component';
import { LayoutModule } from '././../layout/layout.module'



/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent,UsersComponent, WorkInProgressComponent, CandidatoComponent, CompanyComponent, OpenjobComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    LayoutModule
  ]
})
export class AdminModule { }
