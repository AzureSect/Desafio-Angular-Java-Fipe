package com.fipe.analisador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HistoricoPrecoFipeDTO(
    @JsonProperty("month")
    String mes,
    
    @JsonProperty("price")
    String preco,
    
    @JsonProperty("reference")
    String referencia
    
){}
