import { Component, OnInit } from '@angular/core';
import { VehicleService } from 'src/service/vehicle.service';
import { VehicleDTO } from 'src/dto/vehicledto';
@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {
  vehicles: VehicleDTO[];
  vehicletoinsert: VehicleDTO = new VehicleDTO();

  constructor(private service: VehicleService) { }
  ngOnInit() {
    this.getVehicles();
  }

  getVehicles() {
    this.service.getAll().subscribe(vehicles => this.vehicles = vehicles);
  }

  delete(vehicle: VehicleDTO) {
    this.service.delete(vehicle.idVehicle).subscribe(() => this.getVehicles());
  }

  update(vehicle: VehicleDTO) {
    this.service.update(vehicle).subscribe(() => this.getVehicles());
  }

  insert(vehicle: VehicleDTO) {
    this.service.insert(vehicle).subscribe(() => this.getVehicles());
  }

  clear(){
    this.vehicletoinsert = new VehicleDTO();
  }
}

