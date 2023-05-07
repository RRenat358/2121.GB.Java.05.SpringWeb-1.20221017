package ru.rrenat358.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.rrenat358.model.Customer;
import ru.rrenat358.repository.CustomerRepository;

@Component
public class DatabaseFiller {

  @Autowired
  private CustomerRepository repository;

  @EventListener(ApplicationReadyEvent.class)
  public void fillDatabaseOnStartApplication() {
    repository.save(createCustomer("John"));
    repository.save(createCustomer("Peter"));
    repository.save(createCustomer("Johnathan"));
    repository.save(createCustomer("Polo"));
  }

  private Customer createCustomer(String name) {
    Customer customer = new Customer();
    customer.setName(name);
    return customer;
  }

}
