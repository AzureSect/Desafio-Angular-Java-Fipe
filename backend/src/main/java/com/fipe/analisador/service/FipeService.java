package com.fipe.analisador.service;

import com.fipe.analisador.client.FipeClient;
import com.fipe.analisador.dto.ItemFipeDTO;
import com.fipe.analisador.dto.VeiculoDTO;
import com.fipe.analisador.dto.VeiculoFipeResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FipeService {

    private final FipeClient fipeClient;

    @Value("${fipe.api.token}")
    private String token;

    public FipeService(FipeClient fipeClient) {
        this.fipeClient = fipeClient;
    }

    public List<ItemFipeDTO> listarMarcas(String tipo) {
        return fipeClient.buscarMarcas(token, tipo);
    }

    public List<ItemFipeDTO> listarModelos(String tipo, String marcaId) {
        return fipeClient.buscarModelos(token, tipo, marcaId);
    }

    public List<ItemFipeDTO> listarAnos(String tipo, String marcaId, String modeloId) {
        return fipeClient.buscarAnos(token, tipo, marcaId, modeloId);
    }

    public VeiculoDTO obterDetalhes(String tipo, String marcaId, String modeloId, String anoId) {
        
        VeiculoFipeResponseDTO resp = fipeClient.obterDetalhes(token, tipo, marcaId, modeloId, anoId);

        return new VeiculoDTO(
            resp.codigoFipe(),
            resp.modelo(),
            resp.marca(),
            resp.modelo(),
            resp.anoModelo().toString(),
            resp.combustivel(),
            null,
            resp.siglaCombustivel(),
            "18/01/2026",
            null,
            null,
            null,
            null,
            0.0,
            0.0,
            0.0,
            null 
        );
    }
}