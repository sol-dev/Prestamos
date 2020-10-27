package com.example.pruebaRest.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrestamo;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "monto")
    private double monto;

    @Column(name = "interes")
    private double interes;

    @Column(name = "cantCuotas")
    private int cantCuotas;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    @JsonIgnoreProperties("prestamos")
    private Cliente cliente;

    public Prestamo(){}

    public Prestamo(int idPrestamo, LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
        this.idPrestamo = idPrestamo;
        this.fecha = fecha;
        this.monto = monto;
        this.interes = interes;
        this.cantCuotas = cantCuotas;
        this.cliente = cliente;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Prestamo [cantCuotas=" + cantCuotas + ", fecha=" + fecha + ", idPrestamo=" + idPrestamo + ", interes="
                + interes + ", monto=" + monto + "]";
    }

    

}
