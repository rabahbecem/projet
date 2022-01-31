import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Role } from './role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  private roleUrl :string;
  constructor(private http:HttpClient) { 
    this.roleUrl='http://localhost:8086/api/role';
  }
  public findAll():Observable<Role[]>{
    return this.http.get<Role[]>(this.roleUrl);
  }
  public save(employee: Role){
    return this.http.post<Role>(this.roleUrl,Role); 
     }
     public delate(id : number){
       return this.http.delete(this.roleUrl+'/'+id,{responseType:'text'});
     }
}
