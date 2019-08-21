import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutModule} from '../layout/layout.module';
import { CandidatoDashboardComponent } from './candidato-dashboard/candidato-dashboard.component';
import { CandidatoRoutingModule } from './candidato-routing.module';
import { FormsModule } from '@angular/forms';
import { ProfilocandidatoComponent } from './profilocandidato/profilocandidato.component';
import { QuestionaryComponent } from './questionary/questionary.component';

@NgModule({
  declarations: [CandidatoDashboardComponent, QuestionaryComponent, ProfilocandidatoComponent],
  imports: [
    CommonModule,
    CandidatoRoutingModule,
    FormsModule,
    LayoutModule
  ]
})
export class CandidatoModule { }
