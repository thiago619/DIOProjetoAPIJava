package me.dio.restaurante.domain.exception;

import java.util.NoSuchElementException;

public class ProdutoNotFoundException extends NoSuchElementException{
    public ProdutoNotFoundException(){
        super("Produto não encontrado");
    }

    public ProdutoNotFoundException(String message){
        super(message);
    }
}
