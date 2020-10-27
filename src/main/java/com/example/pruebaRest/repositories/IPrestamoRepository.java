package com.example.pruebaRest.repositories;

import java.io.Serializable;
import java.util.List;

import com.example.pruebaRest.entities.Prestamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("PrestamoRepository")
public interface IPrestamoRepository extends JpaRepository<Prestamo , Serializable>{
    
    @Query("SELECT p FROM Prestamo p WHERE p.idPrestamo = :idprestamo")
	public Prestamo findPrestamoById(@Param("idprestamo") int id);
    
    @Query("SELECT p FROM Prestamo p WHERE p.cliente.idCliente = :idcli")
    public List<Prestamo> findByClienteId(@Param("idcli") int id);


}
