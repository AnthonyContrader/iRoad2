import { NgModule } from '@angular/core';
import { CandidatoDashboardComponent } from './candidato-dashboard/candidato-dashboard.component';
import { QuestionaryComponent } from './questionary/questionary.component';
import { ProfilocandidatoComponent } from './profilocandidato/profilocandidato.component';
import { Routes, RouterModule } from '@angular/router';
import { CandidatoLayoutComponent } from '../layout/candidato-layout/candidato-layout.component';

const routes: Routes = [
  { path: 'candidato-dashboard', component: CandidatoLayoutComponent, children:[
    { path: '', component: CandidatoDashboardComponent},
    { path: 'profilocandidato', component: ProfilocandidatoComponent},
    { path: 'questionary', component: QuestionaryComponent}
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class CandidatoRoutingModule { }
