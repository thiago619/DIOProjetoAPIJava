package me.dio.restaurante.domain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Mesa;
import me.dio.restaurante.domain.model.Request.CreateMesaRequest;
import me.dio.restaurante.domain.service.MesaService;

@RestController
@RequestMapping("/mesa")
@AllArgsConstructor
@Tag(name = "Mesa", description = "APIs para gerenciar mesa")
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("/")
    @Operation(summary = "Retorna todas as mesas cadastradas", description = "Retorna todas as mesas cadastradas")
    public ResponseEntity<List<Mesa>> all(){
        var mesas = this.mesaService.all();
        return ResponseEntity.ok(mesas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma mesa pelo id", description = "Retorna uma mesa pelo id")
    public ResponseEntity<Mesa> byId(@PathVariable Long id){
        var mesa = this.mesaService.byId(id);
        return ResponseEntity.ok(mesa);
    }

    @PostMapping("/")
    @Operation(summary = "Cria uma mesa", description = "Cria uma mesa")
    public ResponseEntity<Mesa> create(@RequestBody CreateMesaRequest mesa){
        var mesaCriada = this.mesaService.create(mesa.toModel());
        return ResponseEntity.ok(mesaCriada);
    }
}
