package com.example.pruebaRest.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="cuota")
public class Cuota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuota;

    @ManyToOne
    @JoinColumn(name = "fk_prestamo")
    @JsonIgnore
    private Prestamo prestamo;

    @Column(name = "nroCuota")
    private int nroCuota;

    @Column(name ="fechaVencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "interesCuota")
    private double interesCuota;

    @Column(name= "monto")
    private double monto;

    @Column(name = "deuda")
    private double deuda;

    @Column(name = "cancelada")
    private boolean cancelada;

    @Column(name="fechaDePago")
    private LocalDate fechaDePago;


    public Cuota(){}

    public Cuota(int idCuota, Prestamo prestamo, int nroCuota, LocalDate fechaVencimiento, double interesCuota,
            double monto, double deuda, boolean cancelada, LocalDate fechaDePago) {
        this.idCuota = idCuota;
        this.prestamo = prestamo;
        this.nroCuota = nroCuota;
        this.fechaVencimiento = fechaVencimiento;
        this.interesCuota = interesCuota;
        this.monto = monto;
        this.deuda = deuda;
        this.cancelada = cancelada;
        this.fechaDePago = fechaDePago;
    }


    public int getIdCuota() {
        return idCuota;
    }

    protected void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    public double getInteresCuota() {
        return interesCuota;
    }

    public void setInteresCuota(double interesCuota) {
        this.interesCuota = interesCuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public LocalDate getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(LocalDate fechaDePago) {
        this.fechaDePago = fechaDePago;
    }


}
