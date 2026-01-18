package com.fipe.analisador.enums;

import lombok.Getter;

@Getter
public enum TipoCombustivel {
    GASOLINA("G", "Gasolina"),
    DIESEL("D", "Diesel"),
    ALCOOL("A", "Álcool / Flex");

    private final String sigla;
    private final String descricao;

    TipoCombustivel(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }
    
    public static TipoCombustivel fromSigla(String sigla) {
        for (TipoCombustivel t : values()) {
            if (t.sigla.equalsIgnoreCase(sigla)) return t;
        }
        return GASOLINA; // Default
    }

}
