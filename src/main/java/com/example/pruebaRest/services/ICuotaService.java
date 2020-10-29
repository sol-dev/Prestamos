package com.example.pruebaRest.services;

import com.example.pruebaRest.entities.Prestamo;

import java.util.List;

import com.example.pruebaRest.entities.Cuota;


public interface ICuotaService {
    
    public void generar(Prestamo prestamo);

    public List<Cuota> findAll();

    public Cuota pagarCuota(int idCuota);

    public List<Cuota> findByPrestamo(int idPrestamo);
}
