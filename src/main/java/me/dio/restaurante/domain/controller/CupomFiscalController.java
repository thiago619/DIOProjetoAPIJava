package me.dio.restaurante.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.CupomFiscal;
import me.dio.restaurante.domain.service.CupomFiscalService;

@AllArgsConstructor
@RestController
@RequestMapping("/cupom")
public class CupomFiscalController {
    private final CupomFiscalService cupomService;

    @GetMapping("/{id}")
    public ResponseEntity<CupomFiscal> byId(@PathVariable Long id){
        var cupom = this.cupomService.byId(id);
        return ResponseEntity.ok(cupom);
    }

}
