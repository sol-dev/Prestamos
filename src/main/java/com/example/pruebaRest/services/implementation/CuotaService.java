package com.example.pruebaRest.services.implementation;

import java.time.LocalDate;
import java.util.List;

import com.example.pruebaRest.entities.Cuota;
import com.example.pruebaRest.entities.Prestamo;
import com.example.pruebaRest.repositories.ICuotaRepository;
import com.example.pruebaRest.services.ICuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("cuotaService")
public class CuotaService implements ICuotaService {

    @Autowired
    @Qualifier("CuotaRepository")
    private ICuotaRepository iCuotaRepository;

    @Override
    public void generar(Prestamo prestamo) {
        
        nCuotas(prestamo);

    }

    public Cuota calcularGenericosCuota(Prestamo prestamo){
        Cuota cuota= new Cuota();
        double interesPorcentaje= (prestamo.getInteres()/100)+1;
        double montoCuota= (prestamo.getMonto()*interesPorcentaje)/prestamo.getCantCuotas();
        double montoInteresxCuota= montoCuota*(prestamo.getInteres()/100);

        cuota.setPrestamo(prestamo);
        cuota.setInteresCuota(montoInteresxCuota);
        cuota.setMonto(montoCuota);
        cuota.setCancelada(false);
        return cuota;        
    }
     /*de cada cuota varia:
        -setNroCuota
        -fechas
        -deuda
    */
    public void nCuotas(Prestamo prestamo){
        int cant= 1;
        Cuota cuota;
        int cuotasPendientes= prestamo.getCantCuotas();
        double deuda;
        LocalDate fechaVencimiento= prestamo.getFecha();
        int month;
        int day= fechaVencimiento.getDayOfMonth();
        int year= fechaVencimiento.getYear();
        while(cant<=prestamo.getCantCuotas()){
            cuota = calcularGenericosCuota(prestamo);
            cuota.setNroCuota(cant);
            
            deuda=cuota.getMonto()*cuotasPendientes;
            cuota.setDeuda(deuda);

            //month value 1 to 12
            if (fechaVencimiento.getMonthValue()!=12){
                month= fechaVencimiento.getMonthValue()+1;
                
            }else{
                year=year+1;
                month=1;
            }
            fechaVencimiento = LocalDate.of(year, month, day);
            cuota.setFechaVencimiento(fechaVencimiento);

            cant++;
            cuotasPendientes--;

            iCuotaRepository.save(cuota);
        }
    }

    @Override
    public List<Cuota> findAll() {
        return iCuotaRepository.findAll();
    }


    @Override
    public Cuota pagarCuota(int idCuota){
        Cuota cuota = iCuotaRepository.findCuotaById(idCuota);
        cuota.setCancelada(true);
        cuota.setFechaDePago(LocalDate.now());
        return iCuotaRepository.saveAndFlush(cuota);
    } 

    @Override
    public List<Cuota> findByPrestamo(int idPrestamo){
        return iCuotaRepository.findByPrestamoId(idPrestamo);
    }


}