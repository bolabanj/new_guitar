package edu.iu.bolabanj.c322spring2024homework2.controllers;

import edu.iu.bolabanj.c322spring2024homework2.model.Customer;
import edu.iu.bolabanj.c322spring2024homework2.repository.CustomerFileRepository;
import edu.iu.bolabanj.c322spring2024homework2.repository.CustomerRepository;
import edu.iu.bolabanj.c322spring2024homework2.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    CustomerRepository customerFileRepository;
    public AuthenticationController(CustomerRepository
                                            customerFileRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.customerFileRepository = customerFileRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(customer.getPassword());
            customer.setPassword(encodedPassword);
            customerFileRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/signin")
    public String login(@RequestBody Customer customer){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
        return tokenService.generateToken(authentication);
    }
}
