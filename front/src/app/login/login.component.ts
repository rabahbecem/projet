import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public employee : Employee;
  public emp : Employee;
  msg='';
  constructor(private route: ActivatedRoute,private router: Router,private EmployeeService: EmployeeService) {
    this.employee=new Employee();
    this.emp = new Employee();
  }

  ngOnInit(): void {
  }
  Ajouter(form: NgForm){
    
   
    this.EmployeeService.login(this.employee).subscribe(
      data =>{this.employee = data;
       
        if(this.employee.role=="user"){
          console.log('login correct');
        this.router.navigate(['/user']);}
      else{
        this.router.navigate(['/employee']);
      }},error => {console.log('erreuur');
      this.msg="user name or password incorrect";
        
      }
      )
   
    
      
  }
}


