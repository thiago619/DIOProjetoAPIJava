package me.dio.restaurante.domain.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Pedido;
import me.dio.restaurante.domain.model.Request.CreatePedidoRequest;
import me.dio.restaurante.domain.repository.PedidoRepository;
import me.dio.restaurante.domain.service.ClienteService;
import me.dio.restaurante.domain.service.MesaService;
import me.dio.restaurante.domain.service.PedidoService;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService{
    private MesaService mesaService;
    private ClienteService clienteService;
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

}
