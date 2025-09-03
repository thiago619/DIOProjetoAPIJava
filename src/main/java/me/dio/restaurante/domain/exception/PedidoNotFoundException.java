package me.dio.restaurante.domain.exception;

import java.util.NoSuchElementException;

public class PedidoNotFoundException extends NoSuchElementException{

    public PedidoNotFoundException() {
        super("O pedido não existe");
    }

    public PedidoNotFoundException(String s) {
        super(s);
    }
}
