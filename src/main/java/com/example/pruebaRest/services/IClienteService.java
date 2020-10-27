package com.example.pruebaRest.services;

import java.util.List;

import com.example.pruebaRest.entities.Cliente;

public interface IClienteService {
    
    public Cliente save(Cliente cliente);
    
    public Cliente findClienteById(final int id);

    public Cliente findByDni(long dni);

    public void delete(final int id);

    public List<Cliente> findAll();
}
