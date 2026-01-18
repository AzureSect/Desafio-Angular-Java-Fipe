import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FipeService {
  private readonly API = 'http://localhost:8081/api/fipe';

  constructor(private http: HttpClient) {}

  listarMarcas(tipo: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.API}/${tipo}/marcas`);
  }

  listarModelos(tipo: string, marcaId: string): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.API}/${tipo}/marcas/${marcaId}/modelos`,
    );
  }

  listarAnos(
    tipo: string,
    marcaId: string,
    modeloId: string,
  ): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.API}/${tipo}/marcas/${marcaId}/modelos/${modeloId}/anos`,
    );
  }
}
