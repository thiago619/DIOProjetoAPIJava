package me.dio.restaurante.domain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Pedido;
import me.dio.restaurante.domain.model.Request.AddProdutotoPedidoRequest;
import me.dio.restaurante.domain.model.Request.CreatePedidoRequest;
import me.dio.restaurante.domain.service.PedidoService;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "APIs para gerenciar pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping("/")
    @Operation(summary = "Cadastra um pedido", description = "Cadastra um pedido. A mesa deve estar fechada, ou seja, sem nenhum pedido em aberto")
    public ResponseEntity<Pedido> create(@RequestBody CreatePedidoRequest pedidoRequest){
        Pedido pedido = pedidoService.create(pedidoRequest);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/")
    @Operation(summary = "Retorna todos os pedidos", description = "Retorna todos os pedidos")
    public ResponseEntity<List<Pedido>> all(){
        var pedidos = pedidoService.all();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/add")
    @Operation(summary = "Adiciona itens no pedido", description = "Adiciona itens no pedido. O pedido deve estar aberto, se já houver o mesmo produto é somado. Essa rota não extorna itens")
    public ResponseEntity<Pedido> addProduto(@RequestBody AddProdutotoPedidoRequest addProdutotoPedidoRequest){
        var pedido = pedidoService.addProduto(addProdutotoPedidoRequest);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}/fechar")
    @Operation(summary = "Fecha o pedido.(Fecha a conta).", description = "Fecha o pedido.(Fecha a conta). O pedido deve ter um valor maior que 1, e não pode já estar fechado ou pago. Ao fechar, o pedido fica aguardando pagamento, e a mesa associada a ele é liberada pra receber outros pedidos")
    public ResponseEntity<Pedido> fechar(@PathVariable Long id){
        var pedido = this.pedidoService.fechar(id);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}/pagar")
    @Operation(summary = "Paga um pedido", description = "Paga um pedido. O pedido de ve estar fechado. Ao ser pago, emite o cupom fiscal")
    public ResponseEntity<Pedido> pagar(@PathVariable Long id){
        var pedido = this.pedidoService.pagar(id);
        return ResponseEntity.ok(pedido);
    }

}
