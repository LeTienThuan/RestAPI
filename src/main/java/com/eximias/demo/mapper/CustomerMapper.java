package com.eximias.demo.mapper;

import com.eximias.demo.dto.CustomerDTO;
import com.eximias.demo.entity.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO convertToDto(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer convertToEntity(CustomerDTO customerDTO);

    Customer convertToEntityBelongToOrder(CustomerDTO customerDto);

    List<CustomerDTO> convertToDto(List<Customer> customers);

    @Mapping(target = "id", ignore = true)
    Customer convertToEntity(@MappingTarget Customer customer, CustomerDTO customerDto);


}
