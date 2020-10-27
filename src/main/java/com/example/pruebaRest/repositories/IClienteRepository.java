package com.example.pruebaRest.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.pruebaRest.entities.*;

@Repository("ClienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Serializable>{

    @Query("SELECT c FROM Cliente c WHERE c.idCliente = :idkliente")
	public Cliente findClienteById(@Param("idkliente") int id);
    
    @Query("SELECT c FROM Cliente c WHERE c.dni = :dni")
	public Cliente findByDni(@Param("dni") long dni_c);
}