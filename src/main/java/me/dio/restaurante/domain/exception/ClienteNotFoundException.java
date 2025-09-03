package me.dio.restaurante.domain.exception;

import java.util.NoSuchElementException;

public class ClienteNotFoundException extends NoSuchElementException{
    public ClienteNotFoundException(){
        super("O cliente não foi encontrado");
    }

    public ClienteNotFoundException(String message){
        super(message);
    }
}
