package com.fipe.analisador.client;

import com.fipe.analisador.dto.ItemFipeDTO;
import com.fipe.analisador.dto.VeiculoFipeResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "fipeClient", url = "https://fipe.parallelum.com.br/api/v2")
public interface FipeClient {

    @GetMapping("/{tipo}/brands")
    List<ItemFipeDTO> buscarMarcas(
        @RequestHeader("X-Subscription-Token") String token,
        @PathVariable("tipo") String tipo);

    @GetMapping("/{tipo}/brands/{marcaId}/models")
    List<ItemFipeDTO> buscarModelos(
        @RequestHeader("X-Subscription-Token") String token,
        @PathVariable("tipo") String tipo,
        @PathVariable("marcaId") String marcaId);

    @GetMapping("/{tipo}/brands/{marcaId}/models/{modeloId}/years")
    List<ItemFipeDTO> buscarAnos(
        @RequestHeader("X-Subscription-Token") String token,
        @PathVariable("tipo") String tipo,
        @PathVariable("marcaId") String marcaId,
        @PathVariable("modeloId") String modeloId);

    @GetMapping("/{tipo}/brands/{marcaId}/models/{modeloId}/years/{anoId}")
    VeiculoFipeResponseDTO obterDetalhes(
        @RequestHeader("X-Subscription-Token") String token,
        @PathVariable("tipo") String tipo,
        @PathVariable("marcaId") String marcaId,
        @PathVariable("modeloId") String modeloId,
        @PathVariable("anoId") String anoId);

     @GetMapping("/{tipo}/{codigoFipe}/years/{anoId}/history")
VeiculoFipeResponseDTO obterHistorico(
    @RequestHeader("X-Subscription-Token") String token,
    @PathVariable("tipo") String tipo,
    @PathVariable("codigoFipe") String codigoFipe,
    @PathVariable("anoId") String anoId
);

}