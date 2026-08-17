package pe.edu.vallegrande.app.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import pe.edu.vallegrande.app.model.Customer;
import pe.edu.vallegrande.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "Customer", description = "Endpoints reactivos para la gestión de clientes con MongoDB")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }

    @Operation(summary = "Obtener un cliente por ID")
    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @Operation(summary = "Registrar o guardar cliente")
    @PostMapping
    public Mono<Customer> saveDirect(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @Operation(summary = "Registrar o guardar cliente (/save)")
    @PostMapping("/save")
    public Mono<Customer> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

}
