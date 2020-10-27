package com.example.pruebaRest.services.implementation;

import java.util.List;

import com.example.pruebaRest.entities.Cliente;
import com.example.pruebaRest.repositories.IClienteRepository;
import com.example.pruebaRest.services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("clienteService")
public class ClienteService implements IClienteService {

    @Autowired
    @Qualifier("ClienteRepository")
    private IClienteRepository iClienteRepository;

    public Cliente save(Cliente cliente) {
        return iClienteRepository.saveAndFlush(cliente);
    }

    public Cliente findClienteById(int id) {
        return iClienteRepository.findClienteById(id);
    }

    public Cliente findByDni(long dni) {
        return iClienteRepository.findByDni(dni);
    }
    
    public void delete(int id) {
        iClienteRepository.delete(iClienteRepository.findById(id).get());
	}


    public List<Cliente> findAll() {
        return iClienteRepository.findAll();
    }
    
}

/*
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return repository.save(employee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }

    */
