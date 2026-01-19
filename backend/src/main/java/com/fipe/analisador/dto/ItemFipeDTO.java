package com.fipe.analisador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemFipeDTO(
    @JsonProperty("code")
    String codigo, 
    @JsonProperty("name")
    String nome,
    @JsonProperty("codeFipe")
    String codeFipe
) {}