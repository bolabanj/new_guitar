package edu.iu.bolabanj.c322spring2024homework2.controllers;

import edu.iu.bolabanj.c322spring2024homework2.model.Customer;
import edu.iu.bolabanj.c322spring2024homework2.repository.CustomerRepository;
import edu.iu.bolabanj.c322spring2024homework2.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    CustomerRepository customerRepository;
    public AuthenticationController(CustomerRepository
                                            customerRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/signin")
    public String login(@RequestBody Customer customer){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customer.username(), customer.password()));
        return tokenService.generateToken(authentication);
    }
}
