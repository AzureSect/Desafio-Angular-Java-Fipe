import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ConsultaFipeComponent } from './fipe/consulta-fipe/consulta-fipe.component';
import { ResultadoFipeComponent } from './fipe/resultado-fipe/resultado-fipe.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'consulta', component: ConsultaFipeComponent },
  { path: 'resultado', component: ResultadoFipeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
