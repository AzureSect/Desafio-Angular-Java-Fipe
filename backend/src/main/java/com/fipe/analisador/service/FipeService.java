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
}