package me.dio.restaurante.domain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Pedido;
import me.dio.restaurante.domain.model.Request.AddProdutotoPedidoRequest;
import me.dio.restaurante.domain.model.Request.CreatePedidoRequest;
import me.dio.restaurante.domain.service.PedidoService;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService pedidoService;

    @PostMapping("/")
    public ResponseEntity<Pedido> create(@RequestBody CreatePedidoRequest pedidoRequest){
        Pedido pedido = pedidoService.create(pedidoRequest);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> all(){
        var pedidos = pedidoService.all();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/add")
    public ResponseEntity<Pedido> addProduto(@RequestBody AddProdutotoPedidoRequest addProdutotoPedidoRequest){
        var pedido = pedidoService.addProduto(addProdutotoPedidoRequest);
        return ResponseEntity.ok(pedido);
    }

}
