package me.dio.restaurante.domain.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Pedido;
import me.dio.restaurante.domain.model.PedidoProduto;
import me.dio.restaurante.domain.model.PedidoProdutoId;
import me.dio.restaurante.domain.model.Produto;
import me.dio.restaurante.domain.model.Request.AddProdutotoPedidoRequest;
import me.dio.restaurante.domain.model.Request.CreatePedidoRequest;
import me.dio.restaurante.domain.repository.PedidoRepository;
import me.dio.restaurante.domain.service.ClienteService;
import me.dio.restaurante.domain.service.MesaService;
import me.dio.restaurante.domain.service.PedidoService;
import me.dio.restaurante.domain.service.ProdutoService;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService{
    private MesaService mesaService;
    private ClienteService clienteService;
    private ProdutoService produtoService;
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido create(CreatePedidoRequest pedidoRequest) {
        var mesa = this.mesaService.byId(pedidoRequest.getMesa_id());
        var cliente = this.clienteService.byId(pedidoRequest.getCliente_id());
        if(mesa.getAberta()){
            throw new RuntimeException("Não é possível marcar pedido pois a mesa já está aberta");
        }
        Pedido pedido = new Pedido();
        pedido.setAbertoEm(ZonedDateTime.now());
        pedido.setMesa(mesa);
        pedido.setCliente(cliente);
        pedidoRepository.save(pedido);
        pedido = pedidoRepository.findById(pedido.getId()).orElseThrow(NoSuchElementException::new);
        return pedido;
    }

    @Override
    public List<Pedido> all() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido addProduto(AddProdutotoPedidoRequest addProdutotoPedidoRequest) {
        Pedido pedido = this.pedidoRepository.findById(addProdutotoPedidoRequest.getPedido_id()).orElseThrow(NoSuchElementException::new);
        Produto produto = this.produtoService.byId(addProdutotoPedidoRequest.getProduto_id());

        if(pedido.getFechadoEm() != null) throw new RuntimeException("Não pode adicionar item em um pedido fechado");
        PedidoProdutoId pedidoProdutoId = new PedidoProdutoId();
        pedidoProdutoId.setPedido_id(addProdutotoPedidoRequest.getPedido_id());
        pedidoProdutoId.setProduto_id(addProdutotoPedidoRequest.getProduto_id());
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setProduto(produto);
        pedidoProduto.setQuantidade(addProdutotoPedidoRequest.getQuantidade());
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setId(pedidoProdutoId);
        pedido.getPedidoProduto().add(pedidoProduto);
        pedido = this.pedidoRepository.saveAndFlush(pedido);
        return pedido;

    }

}
