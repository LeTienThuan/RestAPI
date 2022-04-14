package com.eximias.demo.controller;

import com.eximias.demo.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.eximias.demo.service.CustomerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int create(@RequestBody CustomerDTO dto) {
        return customerService.create(dto);
    }

    @GetMapping
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id){
        customerService.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public CustomerDTO update(@PathVariable(name = "id") int id, @RequestBody CustomerDTO customerDto){
        return customerService.update(id, customerDto);
    }

}
