package me.dio.restaurante.domain.service;

import java.util.List;

import me.dio.restaurante.domain.model.Pedido;
import me.dio.restaurante.domain.model.Request.AddProdutotoPedidoRequest;
import me.dio.restaurante.domain.model.Request.CreatePedidoRequest;

public interface PedidoService {
    public Pedido create(CreatePedidoRequest pedidoRequest);
    public List<Pedido> all();
    public Pedido addProduto(AddProdutotoPedidoRequest addProdutotoPedidoRequest);
}
