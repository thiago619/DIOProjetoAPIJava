package me.dio.restaurante.domain.exception;

import java.util.NoSuchElementException;

public class MesaNotFoundException extends NoSuchElementException{
    public MesaNotFoundException(){
        super("A mesa não foi encontrada");
    }

    public MesaNotFoundException(String message){
        super(message);
    }
}
