package me.dio.restaurante.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.CupomFiscal;
import me.dio.restaurante.domain.service.CupomFiscalService;

@AllArgsConstructor
@RestController
@RequestMapping("/cupom")
@Tag(name = "Cupom Fiscal", description = "APIs para gerenciar cupom fiscal")
public class CupomFiscalController {
    private final CupomFiscalService cupomService;

    @Operation(summary = "Busca um cupom fiscal pelo id", description = "Busca um cupom fiscal pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<CupomFiscal> byId(@PathVariable Long id){
        var cupom = this.cupomService.byId(id);
        return ResponseEntity.ok(cupom);
    }

}
