package ru.rrenat358.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.model.Customer;
import ru.rrenat358.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping("/{id}")
  public Customer getCustomer(@PathVariable Long id) {
    return customerRepository.getById(id);
  }

  @GetMapping
  public List<Customer> getCustomerByName(@RequestParam String name) {
    return customerRepository.findAllByNameContainingIgnoreCase(name);
  }

  @GetMapping("/all")
  public List<Customer> getCustomers() {
    return customerRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
  }

}
