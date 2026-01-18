package com.fipe.analisador.dto;

import java.util.List;


public record VeiculoDTO(
    String codigoFipe,
    String nome,
    String marca,
    String modelo,
    String anoModelo,
    String combustivel,
    String codigoTipoCombustivel,
    String siglaCombustivel,
    String dataConsulta,
    Double valorReferencia,
    Double valorMedio,
    Double valorMinimo,
    Double valorMaximo,
    Double variacaoMensal,
    Double variacaoAnual,
    Double depreciacaoAcumulada,
    List<ValorDTO> historicoDeValores
) {}