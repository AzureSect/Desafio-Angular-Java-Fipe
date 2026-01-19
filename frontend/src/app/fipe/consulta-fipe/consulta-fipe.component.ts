import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FipeService } from '../../services/fipe.service';

@Component({
  selector: 'app-consulta-fipe',
  templateUrl: './consulta-fipe.component.html',
  styleUrls: ['./consulta-fipe.component.css'],
})
export class ConsultaFipeComponent {
  tipo: string = '';
  marca: string = '';
  modelo: any = '';
  ano: any = null;

  marcas: any[] = [];
  modelos: any[] = [];
  anos: any[] = [];

  constructor(
    private fipeService: FipeService,
    private router: Router,
  ) {}

  carregarMarcas() {
    this.limparDadosPosteriores('tipo');
    if (this.tipo) {
      this.fipeService.listarMarcas(this.tipo).subscribe((dados) => {
        this.marcas = dados;
      });
    }
  }

  carregarModelos() {
    this.limparDadosPosteriores('marca');
    if (this.marca) {
      this.fipeService
        .listarModelos(this.tipo, this.marca)
        .subscribe((dados) => {
          this.modelos = dados;
          console.log('ESTRUTURA DO MODELO:', dados[0]);
        });
    }
  }

  carregarAnos() {
    this.limparDadosPosteriores('modelo');
    if (this.modelo) {
      this.fipeService
        .listarAnos(this.tipo, this.marca, this.modelo)
        .subscribe((dados) => {
          this.anos = dados;
        });
    }
  }

  limparDadosPosteriores(nivel: string) {
    if (nivel === 'tipo') {
      this.marca = '';
      this.marcas = [];
    }
    if (nivel === 'tipo' || nivel === 'marca') {
      this.modelo = '';
      this.modelos = [];
    }
    this.ano = '';
    this.anos = [];
  }
  irParaResultado() {
    console.log('Objeto Ano selecionado:', this.ano);

    const anoIdReal = this.ano?.codigo || this.ano?.code;

    if (!anoIdReal || anoIdReal === 'undefined') {
      alert(
        'Erro: O código do ano não foi identificado. Tente selecionar o ano novamente.',
      );
      console.error('Conteúdo de this.ano:', this.ano);
      return;
    }

    this.fipeService
      .obterDetalhesPorId(this.tipo, this.marca, this.modelo, anoIdReal)
      .subscribe({
        next: (detalhes) => {
          this.router.navigate(['/resultado'], {
            queryParams: {
              tipo: this.tipo,
              codigoFipe: detalhes.codeFipe,
              anoId: anoIdReal,
            },
          });
        },
        error: (err) => {
          console.error('Erro ao buscar detalhes no Java:', err);
        },
      });
  }

  limparFormulario() {
    this.tipo = '';
    this.limparDadosPosteriores('tipo');
  }

  voltarHome() {
    this.router.navigate(['/']);
  }
}
