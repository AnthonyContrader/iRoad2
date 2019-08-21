import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  register (): void{
      this.router.navigate(['/register']);
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((token : any) => {
      localStorage.setItem("autoken", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser", JSON.stringify({ "authorities": token.id_token }));
      this.service.userLogged(this.loginDTO.username).subscribe((user:UserDTO)=>{

        if (user != null) {
          localStorage.setItem('currentUser', JSON.stringify(user));
          console.log(user.authorities);
          if(user.authorities == "ROLE_ADMIN" ) {
            this.router.navigate(['/admin-dashboard']);
          }
          if(user.authorities == "ROLE_COMPANY") {
            this.router.navigate(['/company-dashboard']);
          }
          if(user.authorities == "ROLE_CANDIDATO") {
            this.router.navigate(['/candidato-dashboard']);
          }
        }else{
            alert("Wrong username or password");
          }
        });
      });
      }
  }