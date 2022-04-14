package com.eximias.demo.service;

import com.eximias.demo.dto.CustomerDTO;
import com.eximias.demo.entity.Customer;
import com.eximias.demo.exception.NotFoundException;
import com.eximias.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public int create(CustomerDTO dto) {
        return customerRepository.save(convertToEntity(dto)).getId();
    }

    public Customer convertToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAge(dto.getAge());
        customer.setAddress(dto.getAddress());
        return customer;
    }

    public Customer convertToEntityBelongToOrder(CustomerDTO dto){
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setAge(dto.getAge());
        customer.setAddress(dto.getAddress());
        return customer;
    }

    public List<CustomerDTO> findAll() {
        return convertToDto(customerRepository.findAll());
    }

    public CustomerDTO convertToDto(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAge(customer.getAge());
        customerDto.setAddress(customer.getAddress());
        return customerDto;
    }

    public List<CustomerDTO> convertToDto(List<Customer> customers) {
        return customers
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<Customer> findEntity(int id) {
        return Optional.of(customerRepository.findById(id)
                .orElseThrow(NotFoundException::new));
    }

    public void deleteById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
        }
    }

    public CustomerDTO update(int id, CustomerDTO customerDto) {
        return findEntity(id)
                .map(entity -> convertToEntity(customerDto, entity))
                .map(customerRepository::save)
                .map(this::convertToDto)
                .get();
    }

    private Customer convertToEntity(CustomerDTO dto, Customer entity) {
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setAddress(dto.getAddress());
        return entity;
    }
}
