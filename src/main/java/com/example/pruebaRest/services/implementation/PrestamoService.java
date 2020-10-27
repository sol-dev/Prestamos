package com.example.pruebaRest.services.implementation;

import java.util.List;

import com.example.pruebaRest.entities.Prestamo;
import com.example.pruebaRest.repositories.IPrestamoRepository;
import com.example.pruebaRest.services.IPrestamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("prestamoService")
public class PrestamoService implements IPrestamoService{

    @Autowired
    @Qualifier("PrestamoRepository")
    private IPrestamoRepository iPrestamoRepository;
    
    public Prestamo savePrestamo(Prestamo prestamo){
        return iPrestamoRepository.saveAndFlush(prestamo);    
    }
     
    public Prestamo findById(final int id){
        return iPrestamoRepository.findPrestamoById(id);
    }

    public List<Prestamo> findAll(){
        return iPrestamoRepository.findAll();
    }

    public List<Prestamo> findByClienteId(int clienteId){
        return iPrestamoRepository.findByClienteId(clienteId);
    }

    public void deletePrestamo(int idPrestamo){
        iPrestamoRepository.delete(iPrestamoRepository.findPrestamoById(idPrestamo));
    }
}
