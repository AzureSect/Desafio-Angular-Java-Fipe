import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FipeService } from 'src/app/services/fipe.service';

@Component({
  selector: 'app-consulta-fipe',
  templateUrl: './consulta-fipe.component.html',
  styleUrls: ['./consulta-fipe.component.css'],
})
export class ConsultaFipeComponent implements OnInit {
  formFipe: FormGroup;

  tiposVeiculo = [
    { id: 'carros', nome: 'Carro' },
    { id: 'motos', nome: 'Moto' },
    { id: 'caminhoes', nome: 'Caminhão' },
  ];

  marcas: any[] = [];
  modelos: any[] = [];
  anos: any[] = [];

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private fipeService: FipeService,
  ) {
    this.formFipe = this.fb.group({
      tipo: ['', Validators.required],
      marca: [{ value: '', disabled: true }, Validators.required],
      modelo: [{ value: '', disabled: true }, Validators.required],
      ano: [{ value: '', disabled: true }, Validators.required],
    });
  }

  ngOnInit(): void {
    this.formFipe.get('tipo')?.valueChanges.subscribe((tipo) => {
      this.resetarCamposApos('tipo');
      if (tipo) {
        this.fipeService.listarMarcas(tipo).subscribe((dados) => {
          this.marcas = dados;
          this.formFipe.get('marca')?.enable();
        });
      }
    });

    this.formFipe.get('marca')?.valueChanges.subscribe((marcaId) => {
      this.resetarCamposApos('marca');
      const tipo = this.formFipe.get('tipo')?.value;
      if (marcaId && tipo) {
        this.fipeService.listarModelos(tipo, marcaId).subscribe((dados) => {
          this.modelos = dados;
          this.formFipe.get('modelo')?.enable();
        });
      }
    });

    this.formFipe.get('modelo')?.valueChanges.subscribe((modeloId) => {
      this.resetarCamposApos('modelo');
      const tipo = this.formFipe.get('tipo')?.value;
      const marcaId = this.formFipe.get('marca')?.value;
      if (modeloId && tipo && marcaId) {
        this.fipeService
          .listarAnos(tipo, marcaId, modeloId)
          .subscribe((dados) => {
            this.anos = dados;
            this.formFipe.get('ano')?.enable();
          });
      }
    });
  }

  resetarCamposApos(campo: string) {
    if (campo === 'tipo') {
      this.formFipe.get('marca')?.reset({ value: '', disabled: true });
      this.marcas = [];
    }
    if (campo === 'tipo' || campo === 'marca') {
      this.formFipe.get('modelo')?.reset({ value: '', disabled: true });
      this.modelos = [];
    }
    this.formFipe.get('ano')?.reset({ value: '', disabled: true });
    this.anos = [];
  }

  pesquisar() {
    if (this.formFipe.valid) {
      this.router.navigate(['/resultado'], {
        queryParams: this.formFipe.value,
      });
    }
  }

  voltarHome() {
    this.router.navigate(['/']);
  }

  limparFormulario() {
    this.formFipe.reset();
    this.resetarCamposApos('tipo');
  }
}
