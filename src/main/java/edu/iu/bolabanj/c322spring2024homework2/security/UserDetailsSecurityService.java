package edu.iu.bolabanj.c322spring2024homework2.security;

import edu.iu.bolabanj.c322spring2024homework2.model.Customer;
import edu.iu.bolabanj.c322spring2024homework2.repository.CustomerFileRepository;
import edu.iu.bolabanj.c322spring2024homework2.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurityService implements UserDetailsService {
    CustomerRepository customerFileRepository;

    public UserDetailsSecurityService(CustomerRepository customerFileRepository){
        this.customerFileRepository = customerFileRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Customer customer = customerFileRepository.findByUsername(username);
            if (customer == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return User.withUsername(username).password(customer.getPassword()).build();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
