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
    
    @Query("SELECT p FROM Prestamo p WHERE p.fk_cliente = :idcliente")
	public List<Prestamo> findByClienteId(@Param("idcliente") long idCliente);
   /* @Query("SELECT s FROM Subcategory s WHERE s.category.idCategory = :idCategory")
	public abstract List<Subcategory> findSubcategoryByCategory(@Param("idCategory") int idCategory);
    */
}
