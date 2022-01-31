import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private employeeUrl :string;
  private employeeUrl1 :string;
  private employeeUrl2 :string;
  private employee !: Employee;
  constructor(private http:HttpClient) { 
    this.employeeUrl='http://localhost:8086/api/employee';
    this.employeeUrl1='http://localhost:8086/api/login';
    this.employeeUrl2='http://localhost:8086/api/user';
  }
 
  public findAll():Observable<Employee[]>{
    
    const headers = new HttpHeaders(this.employee ? {
      authorization : 'Basic ' + btoa(this.employee.userName + ':' + this.employee.password)
  } : {});
    
    return this.http.get<Employee[]>(this.employeeUrl);
  }
  public save(employee: Employee){
    return this.http.post<Employee>(this.employeeUrl,employee); 
     }
     public delate(id : number){
       return this.http.delete(this.employeeUrl+'/'+id,{responseType:'text'});
     }
     public finduser():Observable<Employee>{
      return this.http.get<Employee>(this.employeeUrl2);
     }

     public login(employee : Employee ){
      const headers = new HttpHeaders(employee ? {
        authorization : 'Basic ' + btoa(employee.userName + ':' + employee.password)
    } : {});
      return this.http.post<Employee>(this.employeeUrl1,employee);
     }
}
