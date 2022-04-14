package com.eximias.demo.service;

import com.eximias.demo.dto.ProductDTO;
import com.eximias.demo.entity.Product;
import com.eximias.demo.exception.NotFoundException;
import com.eximias.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDTO convertToDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setTrademark(product.getTrademark());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    public List<ProductDTO> convertToDto(List<Product> products) {
        return products
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Product convertToEntity(ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setTrademark(productDto.getTrademark());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public Product convertToEntity(ProductDTO productDto, Product product) {
        product.setName(productDto.getName());
        product.setTrademark(productDto.getTrademark());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public Optional<Product> findEntity(int id) {
        return Optional.of(productRepository.findById(id)
                .orElseThrow(NotFoundException::new));
    }

    public List<ProductDTO> findAll() {
        return convertToDto(productRepository.findAll());
    }

    public int create(ProductDTO productDto) {
        return productRepository.save(convertToEntity(productDto)).getId();
    }

    public void deleteById(int id) {
        Optional<Product> products = productRepository.findById(id);
        if (products.isPresent()) {
            productRepository.deleteById(id);
        }
    }

    public ProductDTO update(int id, ProductDTO productDto) {
        return findEntity(id)
                .map(entity -> convertToEntity(productDto, entity))
                .map(productRepository::save)
                .map(this::convertToDto).get();
    }
}