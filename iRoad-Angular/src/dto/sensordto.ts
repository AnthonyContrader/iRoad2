import {Sensortype} from './sensortype';

/**
 * Classe DTO di Sensor. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 
 */
export class SensorDTO {

   idSensor: number;
  
   longSensor: number;

   latSensor: number;

   sensortype: Sensortype;

}

