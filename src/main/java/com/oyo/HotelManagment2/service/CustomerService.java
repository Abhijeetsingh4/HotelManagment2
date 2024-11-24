package com.oyo.HotelManagment2.service;

import com.oyo.HotelManagment2.entity.AdharDetails;
import com.oyo.HotelManagment2.entity.Customer;
import com.oyo.HotelManagment2.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;


    public Boolean createCustomer(Customer customer) {
        AdharDetails adharDetails=customer.getAdharDetails();
        adharDetails.setCustomer(customer);
        customerRepository.save(customer);
        return  true;

    }

    public Customer getCustomerDetails(Integer customerId) {
        Optional<Customer> customer=customerRepository.findById(customerId);
        return  customer.get();

    }

    public List<Customer> findByEmail(String email) {
       return customerRepository.findByEmail(email);


    }
}
