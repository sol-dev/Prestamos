package com.example.pruebaRest.repositories;

import java.io.Serializable;
import java.util.List;

import com.example.pruebaRest.entities.Cuota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("CuotaRepository")
public interface ICuotaRepository extends JpaRepository<Cuota, Serializable>{
    
    @Query("SELECT c FROM Cuota c WHERE c.idCuota = :id_cuota")
	public Cuota findCuotaById(@Param("id_cuota") int id);
  
    @Query("SELECT c FROM Cuota c WHERE c.prestamo.idPrestamo = :id_prestamo")
    public List<Cuota> findByPrestamoId(@Param("id_prestamo") int id);
}
