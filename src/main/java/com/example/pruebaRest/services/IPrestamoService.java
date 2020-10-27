package com.example.pruebaRest.services;

import java.util.List;

import com.example.pruebaRest.entities.Prestamo;

public interface IPrestamoService {

    public Prestamo savePrestamo(Prestamo prestamo);

    public Prestamo findById(final int id);

    public List<Prestamo> findAll(); 

    public List<Prestamo> findByClienteId(int clienteId);

    public void deletePrestamo(int idPrestamo);


}
