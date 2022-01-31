import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserAdmComponent } from './user-adm/user-adm.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path: 'employee',component:UserAdmComponent},
  {path: 'user',component:UserComponent},
  {path: 'login',component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
