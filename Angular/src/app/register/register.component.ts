import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userDTO: UserDTO;
  usertoinsert: UserDTO =new UserDTO();
  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
    this.userDTO =new UserDTO();
  }

  register(user: UserDTO): void {
    this.service.register(this.usertoinsert).subscribe(()=> this.router.navigate(['login']))
  }


}
