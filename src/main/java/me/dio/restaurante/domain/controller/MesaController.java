package me.dio.restaurante.domain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Mesa;
import me.dio.restaurante.domain.service.MesaService;

@RestController
@RequestMapping("/mesa")
@AllArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("/")
    public ResponseEntity<List<Mesa>> all(){
        var mesas = this.mesaService.all();
        return ResponseEntity.ok(mesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> byId(@PathVariable Long id){
        var mesa = this.mesaService.byId(id);
        return ResponseEntity.ok(mesa);
    }

    @PostMapping("/")
    public ResponseEntity<Mesa> create(@RequestBody Mesa mesa){
        var mesaCriada = this.mesaService.create(mesa);
        return ResponseEntity.ok(mesaCriada);
    }
}
