import { Component, OnInit } from '@angular/core';
import { SensorService } from 'src/service/sensor.service';
import { SensorDTO } from 'src/dto/sensordto';

@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent implements OnInit {

  sensors: SensorDTO[];
  sensortoinsert: SensorDTO = new SensorDTO();

  constructor(private service: SensorService) { }

  ngOnInit() {
    this.getSensors();
  }

  getSensors() {
    this.service.getAll().subscribe(sensors => this.sensors = sensors);
  }

  delete(sensor: SensorDTO) {
    this.service.delete(sensor.idSensor).subscribe(() => this.getSensors());
  }

  update(sensor: SensorDTO) {
    this.service.update(sensor).subscribe(() => this.getSensors());
  }

  insert(sensor: SensorDTO) {
    this.service.insert(sensor).subscribe(() => this.getSensors());
  }

  clear(){
    this.sensortoinsert = new SensorDTO();
  }
}
