package com.example.pruebaRest.entities;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
   //@Column(name = "hola")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni", unique = true,nullable = false)
    private long dni;

    @Column (name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "baja")
    private boolean baja;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Prestamo> prestamos;

    public Cliente() {
    }

    public Cliente(int idCliente, String apellido, String nombre, long dni, LocalDate fechaNacimiento, boolean baja,
            Set<Prestamo> prestamos) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.baja = baja;
        this.prestamos = prestamos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Cliente [apellido=" + apellido + ", baja=" + baja + ", dni=" + dni + ", fechaNacimiento="
                + fechaNacimiento + ", idCliente=" + idCliente + ", nombre=" + nombre  + "]";
    }

    

}
