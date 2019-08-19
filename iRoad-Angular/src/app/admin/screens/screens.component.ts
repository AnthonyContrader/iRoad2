import { Component, OnInit } from '@angular/core';
import { ScreenService } from 'src/service/screen.service';
import { ScreenDTO } from 'src/dto/screendto';

@Component({
  selector: 'app-screens',
  templateUrl: './screens.component.html',
  styleUrls: ['./screens.component.css']
})
export class ScreensComponent implements OnInit {

  screens: ScreenDTO[];
  screentoinsert: ScreenDTO = new ScreenDTO();

  constructor(private service: ScreenService) { }

  ngOnInit() {
    this.getScreens();
  }

  getScreens() {
    this.service.getAll().subscribe(screens => this.screens = screens);
  }

  delete(screen: ScreenDTO) {
    this.service.delete(screen.idScreen).subscribe(() => this.getScreens());
  }

  update(screen: ScreenDTO) {
    this.service.update(screen).subscribe(() => this.getScreens());
  }

  insert(screen: ScreenDTO) {
    this.service.insert(screen).subscribe(() => this.getScreens());
  }

  clear(){
    this.screentoinsert = new ScreenDTO();
  }
}
