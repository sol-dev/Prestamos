package com.example.pruebaRest.controllers;

import java.util.List;

import com.example.pruebaRest.entities.Cliente;
import com.example.pruebaRest.services.IClienteService;

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
@RequestMapping("/cliente")
public class ClienteRestController{

  @Autowired
  @Qualifier("clienteService")
  private IClienteService clienteService;

  //add cliente
  @PostMapping(value = "/add", consumes="application/json")
  public Object createCliente(@RequestBody Cliente cliente){
      System.out.println("Cliente: "+ cliente.toString());
      return clienteService.save(cliente);
  }

  @GetMapping("/id") 
  public Cliente findById(@RequestParam("idCliente") int id) {
      return clienteService.findClienteById(id);
          //.orElseThrow(() -> new ClienteNotFoundException(id));;
  }

  @GetMapping("/dni")
  public Cliente findByDni(@RequestParam("dni") int dni_c){
      return clienteService.findByDni(dni_c);
  }

  @GetMapping("/all")
  public List<Cliente> findAll(){
      return clienteService.findAll();
  }

  
  @PutMapping("/update")
  public Cliente update(@RequestParam int id,@RequestBody Cliente newCliente) {
    /*recibo el id del usuario sobre el que voy a realizar el update
      mando por json el objeto con los atributos solo que quiero modificar   */
    
    Cliente aux= clienteService.findClienteById(id);
    if(aux!=null){
      if(newCliente.getApellido()!=null)
        aux.setApellido(newCliente.getApellido());
      if(newCliente.getNombre()!=null)
        aux.setNombre(newCliente.getNombre());
      if(newCliente.getFechaNacimiento()!=null)
        aux.setFechaNacimiento(newCliente.getFechaNacimiento());
      return clienteService.save(aux);
      
    }else{
      /* agregar el cliente nuevo si no lo encuentra para update
      //no valido si el dni ya existe si es asi da error
      //newCliente.setIdCliente(id); no anda porque es autoincrementable
      return clienteService.save(newCliente);*/
      return null;
    }
  }

  //implementar baja logica(seria una modificacion)
  @PutMapping("/baja")
  public String baja(@RequestParam int id){
    Cliente aux= clienteService.findClienteById(id);
    String rta="";
    if(aux!=null){
        aux.setBaja(true);
        clienteService.save(aux);
        rta= "Cliente dado de baja";
    }else{
        rta="Cliente no existente";
    }
    return rta;
  } 

  @DeleteMapping(value = "/delete")
	public String delete(@RequestParam("id") int id){
		clienteService.delete(id);
		return ("Cliente eliminado de forma permanente");
	}
}
/*
@PutMapping("/{nombre}")
public void actualizar(@PathVariable("nombre") String nombre, @RequestBody Persona persona) {
  
  
  listaPersonas.remove(new Persona(nombre));
  listaPersonas.add(persona);
}*/

/*

  // Single item

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

*/