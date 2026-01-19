package com.fipe.analisador.service;

import com.fipe.analisador.client.FipeClient;
import com.fipe.analisador.dto.HistoricoPrecoFipeDTO;
import com.fipe.analisador.dto.ItemFipeDTO;
import com.fipe.analisador.dto.VeiculoFipeResponseDTO;
import com.fipe.analisador.enums.TipoVeiculo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FipeService {

    private final FipeClient fipeClient;

    @Value("${FIPE_TOKEN}")
    private String token;

    public FipeService(FipeClient fipeClient) {
        this.fipeClient = fipeClient;
    }

    public List<ItemFipeDTO> listarMarcas(String tipo) {
        TipoVeiculo veiculo = TipoVeiculo.valueOf(tipo.toUpperCase()); 
        List<ItemFipeDTO> marcas = fipeClient.buscarMarcas(token, veiculo.getPath());

        return marcas;
    }

    public List<ItemFipeDTO> listarModelos(String tipo, String marcaId) {
        String path = TipoVeiculo.valueOf(tipo.toUpperCase()).getPath(); 
        return fipeClient.buscarModelos(token, path, marcaId);
    }

    public List<ItemFipeDTO> listarAnos(String tipo, String marcaId, String modeloId) {
        String path = TipoVeiculo.valueOf(tipo.toUpperCase()).getPath();
        return fipeClient.buscarAnos(token, path, marcaId, modeloId);
    }

   public Map<String, Object> consultarHistoricoComResumo(String tipo, String codigoFipe, String anoId) {
    String path = TipoVeiculo.valueOf(tipo.toUpperCase()).getPath(); 
    VeiculoFipeResponseDTO dados = fipeClient.obterHistorico(token, path, codigoFipe, anoId);
    
    List<HistoricoPrecoFipeDTO> historicoAnual = new ArrayList<>();
    var history = dados.priceHistory();
    for (int i = 0; i < history.size(); i += 1) {
        var atual = history.get(i);
        Double percentual = 0.0;
        String mensagem = "";

        if (i + 1 < history.size()) {
            var anterior = history.get(i + 1);
            double vAtual = converterPreco(atual.preco());
            double vAnterior = converterPreco(anterior.preco());
            percentual = (vAnterior != 0) ? ((vAtual - vAnterior) / vAnterior) * 100 : 0.0;
            mensagem = String.format("Var. Mensal: %.1f%%", percentual);
        }

        historicoAnual.add(new HistoricoPrecoFipeDTO(
            atual.mesReferencia(), 
            atual.preco(), 
            percentual, 
            mensagem
        ));
    }

    double precoInicial = converterPreco(history.get(history.size() - 1).preco());
    double precoFinal = converterPreco(history.get(0).preco());
    double variacaoTotal = ((precoFinal - precoInicial) / precoInicial) * 100;

    Map<String, Object> resposta = new HashMap<>();
    resposta.put("historico", historicoAnual);
    resposta.put("variacaoTotal", variacaoTotal);
    resposta.put("anoFabricacao", dados.anoModelo()); 
    
    return resposta;
}
   private double converterPreco(String preco) {
    if (preco == null || preco.isEmpty()) return 0.0;
    try {
       
        String precoLimpo = preco.replaceAll("[R$\\s.]", "")
                                 .replace(",", "."); 
                                 
        return Double.parseDouble(precoLimpo);
    } catch (Exception e) {
        System.err.println("Falha ao converter o preço: " + preco);
        return 0.0;
    }
}
    public VeiculoFipeResponseDTO obterDetalhes(String tipo, String marcaId, String modeloId, String anoId) {
        String pathTipo = TipoVeiculo.valueOf(tipo.toUpperCase()).getPath();

        return fipeClient.obterDetalhes(token, pathTipo, marcaId, modeloId, anoId);
    }

}