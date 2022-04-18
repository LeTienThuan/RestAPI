package com.eximias.demo.mapper;

import com.eximias.demo.dto.ProductDTO;
import com.eximias.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO convertToDto(Product product);

    @Mapping(target = "id", ignore = true)
    Product convertToEntity(ProductDTO productDto);

    List<ProductDTO> convertToDto(List<Product> products);

    @Mapping(target = "id", ignore = true)
    Product convertToEntity(ProductDTO productDto, @MappingTarget Product product);
}
