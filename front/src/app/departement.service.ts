import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Departement } from './departement';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DepartementService {

  private departementUrl :string;
  constructor(private http:HttpClient) { 
    this.departementUrl='http://localhost:8086/api/departement';
  }
  public findAll():Observable<Departement[]>{
    return this.http.get<Departement[]>(this.departementUrl);
  }
  public save(departement: Departement){
    return this.http.post<Departement>(this.departementUrl,departement); 
     }
     public delate(id : string){
       return this.http.delete(this.departementUrl+'/'+id,{responseType:'text'});
     }
}
