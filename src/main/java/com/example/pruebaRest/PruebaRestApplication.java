package com.example.pruebaRest;

import com.example.pruebaRest.controllers.PrestamoRestController;
import com.example.pruebaRest.entities.Prestamo;
import com.example.pruebaRest.services.implementation.CuotaService;
import com.example.pruebaRest.services.implementation.PrestamoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaRestApplication.class, args);

		/*
		CuotaService cuotaService= new CuotaService();
		PrestamoService pService= new PrestamoService();
		Prestamo p = pService.findById(1);
		cuotaService.primerCuota(p); */
	}

}
