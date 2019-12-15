/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package kr.co.pohinian.gemfiredemo.controller;

import kr.co.pohinian.gemfiredemo.entity.Customer;
import kr.co.pohinian.gemfiredemo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("{key}")
    public Customer put(@PathVariable("key") Long key, @RequestBody String name) {
        Customer customer = Customer.newCustomer(key, name);
        return customerRepository.save(customer);
    }

    @GetMapping("{key}")
    public Customer get(@PathVariable("key") Long key) {
        return customerRepository.findById(key).orElse(new Customer());
    }

}
