import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resultado-fipe',
  templateUrl: './resultado-fipe.component.html',
  styleUrls: ['./resultado-fipe.component.css'],
})
export class ResultadoFipeComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  voltarParaConsulta() {
    this.router.navigate(['/consulta']);
  }
}
