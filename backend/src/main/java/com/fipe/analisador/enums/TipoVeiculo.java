package com.fipe.analisador.enums;

import lombok.Getter;

@Getter
public enum TipoVeiculo {
    CARROS("cars", 1),
    MOTOS("motorcycles", 2),
    CAMINHOES("trucks", 3);

    private final String path;
    private final int codigo;

    TipoVeiculo(String path, int codigo) {
        this.path = path;
        this.codigo = codigo;
    }

     public static TipoVeiculo fromCodigo(int codigo) {
    for (TipoVeiculo v : values()) {
        if (v.codigo == codigo) return v;
    }
    return CARROS; 
}
}
