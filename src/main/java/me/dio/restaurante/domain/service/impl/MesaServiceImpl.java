package me.dio.restaurante.domain.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.dio.restaurante.domain.model.Mesa;
import me.dio.restaurante.domain.repository.MesaRepository;
import me.dio.restaurante.domain.service.MesaService;

@Service
@AllArgsConstructor
public class MesaServiceImpl implements MesaService{
    private final MesaRepository mesaRepository;

    @Override
    public List<Mesa> all() {
        return this.mesaRepository.findAll();
    }

    @Override
    public Mesa byId(Long id) {
        var mesa = this.mesaRepository.findById(id).orElseThrow(NoSuchElementException::new );
        return mesa;
    }

    @Override
    public Mesa create(Mesa mesa) {
        var mesaCriada = this.mesaRepository.save(mesa);
        //Esse passo a mais criei para poder atualizar os campos anotados com @Formula,
        //pois eles apenas atualizam com select, não com insert
        mesaCriada = this.byId(mesaCriada.getId());
        return mesaCriada;
    }

}
