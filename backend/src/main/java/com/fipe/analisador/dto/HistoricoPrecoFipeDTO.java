package com.fipe.analisador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HistoricoPrecoFipeDTO(
    @JsonProperty("month")
    String mesReferencia, 
    
    @JsonProperty("price")
    String preco,         
    
    Double variacao,     
    
    String descricao     
) {}
