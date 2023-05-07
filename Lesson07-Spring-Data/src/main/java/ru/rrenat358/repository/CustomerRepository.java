package ru.rrenat358.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rrenat358.model.Customer;

import java.util.List;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  // CREATE READ UPDATE DELETE -> CRUD

  @Query(value = """
    select c.id from Customer c where c.name = :name
    """)
  Long findIdByName(String name);

  Customer findByName(String name);

  // select * from customer where name like '%name'
  List<Customer> findAllByNameContainingIgnoreCase(String name);

//  List<Customer> findAllOr();

}
