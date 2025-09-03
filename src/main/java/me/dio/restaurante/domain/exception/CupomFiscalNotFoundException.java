package me.dio.restaurante.domain.exception;

import java.util.NoSuchElementException;

public class CupomFiscalNotFoundException extends NoSuchElementException{

    public CupomFiscalNotFoundException() {
        super("O cupom fiscal não existe");
    }

    public CupomFiscalNotFoundException(String s) {
        super(s);
    }
}
