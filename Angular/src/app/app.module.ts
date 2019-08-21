import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';
import { CandidatoRoutingModule } from './candidato/candidato-routing.module';
import { CompanyRoutingModule } from './company/company-routing.module';
import { CandidatoModule } from './candidato/candidato.module';
import { CompanyModule } from './company/company.module';
import { RegisterModule } from './register/register.module';


/** 
 * Modulo principale dell'applicazione. Qui vengono importati i moduli secondari. L'UNICA component
 * da dichiare qui è l'AppComponent, tutte le altre devono essere dichiarate nel loro modulo e questo importato
 * qui.
 * 
 * @author Vittorio Valent
*/
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    RegisterModule,
    HttpClientModule,
    LayoutModule,
    AdminModule,
    CandidatoRoutingModule,
    CompanyRoutingModule,
    CandidatoModule,
    CompanyModule,
    CompanyRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
