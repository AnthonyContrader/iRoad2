import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { SignalesComponent } from './signales/signales.component';
import { SensorsComponent } from './sensors/sensors.component';
import { StreetsComponent } from './streets/streets.component';
import { ScreensComponent } from './screens/screens.component';
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, VehiclesComponent,SignalesComponent,StreetsComponent,SensorsComponent,ScreensComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
