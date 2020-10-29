package com.example.pruebaRest.controllers;

import java.util.List;

import com.example.pruebaRest.entities.Cuota;
import com.example.pruebaRest.entities.Prestamo;
import com.example.pruebaRest.services.IClienteService;
import com.example.pruebaRest.services.ICuotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:300")
@RequestMapping("/cuota")
public class CuotaRestController {
    @Autowired
    @Qualifier("cuotaService")
    private ICuotaService cuotaService;

    /*uso un get de postman para traer el prestamo en formato json
    http://localhost:8080/prestamo/id?idPrestamo=4
    por json mando en postman: 
    {
        "idPrestamo": 3,
        "fecha": "2020-07-04",
        "monto": 100000.0,
        "interes": 50.0,
        "cantCuotas": 10,
        "cliente": {
            "idCliente": 1,
            "apellido": "hernandez",
            "nombre": "manuel",
            "dni": 12672789,
            "fechaNacimiento": "1978-02-05",
            "baja": false
        }
    }
    */
    @PostMapping(value="/add")
    public void creaCuota(@RequestBody Prestamo prestamo) {
        cuotaService.generar(prestamo);
    }

    @GetMapping(value = "/all")
    public List<Cuota> findAll(){
        return cuotaService.findAll();
    }
    
    @GetMapping(value = "/byPrestamoId")
    public List<Cuota> findByPrestamoId(@RequestParam("idPrestamo") int id){
        return cuotaService.findByPrestamo(id);
    }

    @PutMapping(value = "/pay")
    public Cuota pay(@RequestParam("id") int id){
        return cuotaService.pagarCuota(id);
    }
}
