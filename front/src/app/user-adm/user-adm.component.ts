import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../departement';
import { DepartementService } from '../departement.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Role } from '../role';
import { RoleService } from '../role.service';

@Component({
  selector: 'app-user-adm',
  templateUrl: './user-adm.component.html',
  styleUrls: ['./user-adm.component.css']
})
export class UserAdmComponent implements OnInit {
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
  Supprimer(id : number){
    this.EmployeeService.delate(id).subscribe(
      data => {
        console.log(data);
        this.fetchData();
      }
    )}

}
