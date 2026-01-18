package com.fipe.analisador.controller;

import com.fipe.analisador.client.FipeClient;
import com.fipe.analisador.dto.ItemFipeDTO;
import com.fipe.analisador.dto.VeiculoDTO;
import com.fipe.analisador.dto.VeiculoFipeResponseDTO;
import com.fipe.analisador.service.FipeService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fipe")
@CrossOrigin(origins = "*")
public class FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/{tipo}/marcas")
    public List<ItemFipeDTO> getMarcas(@PathVariable String tipo) {
        return fipeService.listarMarcas(tipo);
    }

    @GetMapping("/{tipo}/marcas/{marcaId}/modelos")
    public List<ItemFipeDTO> getModelos(@PathVariable String tipo, @PathVariable String marcaId) {
        return fipeService.listarModelos(tipo, marcaId);
    }

    @GetMapping("/{tipo}/marcas/{marcaId}/modelos/{modeloId}/anos")
    public List<ItemFipeDTO> getAnos(@PathVariable String tipo, @PathVariable String marcaId, @PathVariable String modeloId) {
        return fipeService.listarAnos(tipo, marcaId, modeloId);
    }

}
