import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { StreetsComponent } from './streets/streets.component';
import { SignalesComponent } from './signales/signales.component';
import { SensorsComponent } from './sensors/sensors.component';
import { ScreensComponent } from './screens/screens.component';


import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'vehicles', component: VehiclesComponent},
    { path: 'signales', component: SignalesComponent},
    { path: 'streets', component: StreetsComponent},
    { path: 'sensors', component: SensorsComponent},
    { path: 'screens', component: ScreensComponent},
    
    { path: 'work-in-progress', component: WorkInProgressComponent},
   
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }