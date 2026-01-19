package com.fipe.analisador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record VeiculoFipeResponseDTO(
    @JsonProperty("codeFipe") String codigoFipe,
    @JsonProperty("model") String modelo,
    @JsonProperty("brand") String marca,
    @JsonProperty("modelYear") Integer anoModelo,
    @JsonProperty("fuel") String combustivel,
    @JsonProperty("fuelAcronym") String siglaCombustivel,
    @JsonProperty("price") String preco,
    @JsonProperty("priceHistory") List<HistoricoPrecoFipeDTO> priceHistory,
    @JsonProperty("vehicleType") Integer tipoVeiculo
) {}