import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../departement';
import { DepartementService } from '../departement.service';
import { Employee } from '../employee';
import { Role } from '../role';
import { EmployeeService } from '../employee.service';
import { RoleService } from '../role.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  myform! : FormGroup;
  public employee : Employee;
  public employees!: Employee[];
  public departements!:Departement[];
  public roles!:Role[];
  public role!:Role;
  constructor(private route: ActivatedRoute,private router: Router,private EmployeeService: EmployeeService,
    private departementService: DepartementService,private roleservice:RoleService) {
     this.employee=new Employee();
     }
     fetchData(){
       this.EmployeeService.findAll().subscribe(data =>{
         this.employees=data;
       });
       this.departementService.findAll().subscribe(data1 =>{
        this.departements=data1;
      });
      this.roleservice.findAll().subscribe(data3 =>{
        this.roles=data3;
      })
     }

  ngOnInit(): void {
    this.fetchData();
  }
  Ajouter(form: NgForm){
    this.EmployeeService.save(this.employee).subscribe(()=>{this.fetchData();});
    form.resetForm();
  }
 


}
