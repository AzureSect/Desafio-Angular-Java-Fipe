package com.fipe.analisador.dto;

import java.util.List;

public record DetalhesVeiculoDTO(
    String codigoFipe,
    String marca,
    String modelo,
    String anoModelo,
    String combustivel,
    String precoAtual,
    String mesReferencia,
    Double variacaoMensal, 
    Double variacaoAnual, 
    List<HistoricoPrecoFipeDTO> historico
) {}