import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyLayoutComponent } from '../layout/company-layout/company-layout.component';
import { CompanyDashboardComponent } from './company-dashboard/company-dashboard.component';
import { ProfiloCompanyComponent } from './profilo-company/profilo-company.component';
import { OpenjobCompanyComponent } from './openjob-company/openjob-company.component';




const routes: Routes = [
  { path: 'company-dashboard', component: CompanyLayoutComponent, children:[
    { path: '', component: CompanyDashboardComponent},
    { path: 'profilo-company', component: ProfiloCompanyComponent},
    { path: 'openjob-company', component: OpenjobCompanyComponent}
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class CompanyRoutingModule { }
