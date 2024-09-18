import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [
  {
    path: "",
    redirectTo: "/Proyecto1/Menu",
    pathMatch: "full"
  },
  {
    path: "Proyecto1/Menu",
    title: "Menu",
    component: MenuComponent
  },
  {
    path: 'Proyecto1/login/:userRole',
    title: "Login",
    component: LoginComponent 
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
