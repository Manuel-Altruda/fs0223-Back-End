import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/homepage/homepage.component';
import { RegisterComponent } from './components/register/register.component';
import { UtentiDispositiviComponent } from './components/utenti-dispositivi/utenti-dispositivi.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthGuard } from './auth.guard';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { DeviceListComponent } from './components/device-list/device-list.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'navbar', component: NavbarComponent},
  { path: 'homepage', component: HomePageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'users-list', component: UsersListComponent /*, canActivate: [AuthGuard], data: { roles: ['admin'] }*/ },
  { path: 'device-list', component: DeviceListComponent /*, canActivate: [AuthGuard], data: { roles: ['admin'] }*/ },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard]
})
export class AppRoutingModule { }
