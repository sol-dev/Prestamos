package com.example.pruebaRest.controllers;

import java.util.List;

import com.example.pruebaRest.entities.Prestamo;
import com.example.pruebaRest.services.IPrestamoService;

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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/prestamo")
public class PrestamoRestController {

    @Autowired
    @Qualifier("prestamoService")
    private IPrestamoService prestamoService;

    //body raw json
    /*  ejemplo como mandar json
    {
        "fecha" : "01/01/2000",
        "monto" : "40000",
        "interes": "25",
        "cantCuotas": "10",
        "cliente":{
            "idCliente": "1"
        }
    }*/
    @PostMapping(value = "/add", consumes="application/json")
    public Object createPrestamo(@RequestBody Prestamo prestamo){
        System.out.println("Prestamo: "+ prestamo.toString());
        return prestamoService.savePrestamo(prestamo);
    } 

    @GetMapping("/id") 
    public Prestamo findById(@RequestParam("idPrestamo") int id) {
        return prestamoService.findById(id);
        //.orElseThrow(() -> new ClienteNotFoundException(id));;
    }

    @GetMapping("/all")
    public List<Prestamo> findAll(){
        return prestamoService.findAll();
    }

    
    @GetMapping("/byCliente")
    public List<Prestamo> findByClienteId(@RequestParam("idCliente") int clienteId){
        return prestamoService.findByClienteId(clienteId);
    }

    @PutMapping("/update")
    public Prestamo update(@RequestParam int id, @RequestBody Prestamo newPrestamo){
        Prestamo aux= prestamoService.findById(id);
        if(aux!=null){
            if(newPrestamo.getFecha()!=null)
                aux.setFecha(newPrestamo.getFecha());
            if(newPrestamo.getMonto()!=0)
                aux.setMonto(newPrestamo.getMonto());
            if(newPrestamo.getInteres()!=0)
                aux.setInteres(newPrestamo.getInteres());
            if(newPrestamo.getCantCuotas()!=0)
                aux.setCantCuotas(newPrestamo.getCantCuotas());
            return prestamoService.savePrestamo(aux);
        }else{
            return null;
        }
    }

    @DeleteMapping("/delete")
    public String deletePrestamo(@RequestParam("id")int idPrestamo){
        prestamoService.deletePrestamo(idPrestamo);
        return("Prestamo eliminado");
    }

}
