import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FipeService } from '../../services/fipe.service';

@Component({
  selector: 'app-resultado-fipe',
  templateUrl: './resultado-fipe.component.html',
  styleUrls: ['./resultado-fipe.component.css'],
})
export class ResultadoFipeComponent implements OnInit {
  historico: any[] = [];
  carregando = true;
  valorAtual: string = '';
  variacaoTotal: number = 0;
  anoFabricacao: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fipeService: FipeService,
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      const { tipo, codigoFipe, anoId } = params;
      this.carregando = true;

      this.fipeService.consultarHistorico(tipo, codigoFipe, anoId).subscribe({
        next: (res: any) => {
          this.variacaoTotal = res.variacaoTotal;
          this.anoFabricacao = res.anoFabricacao;

          if (res.historico) {
            this.historico = res.historico.map((item: any) => ({
              mesReferencia: item.month || item.mesReferencia,
              preco: item.price || item.preco,
              variacao: item.variacao,
              descricao: item.mensagem || item.descricao || 'Referência Atual',
            }));
          }
          this.carregando = false;
        },
        error: (err) => {
          console.error('Erro ao buscar dados:', err);
          this.carregando = false;
        },
      });
    });
  }

  voltar() {
    this.router.navigate(['/']);
  }
}
