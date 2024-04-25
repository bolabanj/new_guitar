package edu.iu.bolabanj.c322spring2024homework2.repository;

import edu.iu.bolabanj.c322spring2024homework2.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, String> {
    Customer findByUsername(String username);
}
