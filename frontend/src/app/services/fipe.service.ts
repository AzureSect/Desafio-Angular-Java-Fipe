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
    return this.http.get<any[]>(`${this.API}/${tipo.toUpperCase()}/marcas`);
  }

  listarModelos(tipo: string, marcaId: string): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.API}/${tipo.toUpperCase()}/marcas/${marcaId}/modelos`,
    );
  }

  listarAnos(
    tipo: string,
    marcaId: string,
    modeloId: string,
  ): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.API}/${tipo.toUpperCase()}/marcas/${marcaId}/modelos/${modeloId}/years`,
    );
  }

  consultarHistorico(
    tipo: string,
    codigoFipe: string,
    anoId: string,
  ): Observable<any> {
    const t = tipo.toUpperCase();
    return this.http.get(
      `${this.API}/${t}/${codigoFipe}/years/${anoId}/history`,
    );
  }

  obterDetalhesPorId(
    tipo: string,
    marcaId: string,
    modeloId: string,
    anoId: string,
  ): Observable<any> {
    const t = tipo.toUpperCase();
    return this.http.get<any>(
      `${this.API}/${t}/marcas/${marcaId}/modelos/${modeloId}/years/${anoId}`,
    );
  }
}
