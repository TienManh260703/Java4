package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Customer;
import com.example.Asm.repository.CustomerRepository;
import com.example.Asm.request.CustomerRequest;
import com.example.Asm.response.CustomerResponse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final CustomerRepository repository = new CustomerRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<CustomerResponse> getAll() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> customers = repository.getAll();
        for (Customer customer : customers) {
            System.out.println(customer);
            responses.add(convert.convertCustomerToCustomerResponse(customer));

        }
        return responses;
    }

    public CustomerResponse getOne(int id) {
        return convert.convertCustomerToCustomerResponse(repository.getOne(id));
    }

    public void create(CustomerRequest request) throws ParseException {
        repository.create(convert.convertCustomerRequestToCustomer(request));
    }

    public void update(CustomerRequest request) throws ParseException {
        repository.update(convert.convertCustomerRequestToCustomer(request));
    }

    public void delete(int id) throws ParseException {
        repository.delete(Customer.builder().id(id).build());
    }
}
