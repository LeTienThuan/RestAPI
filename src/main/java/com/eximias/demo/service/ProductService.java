package com.eximias.demo.service;

import com.eximias.demo.dto.ProductDTO;
import com.eximias.demo.entity.Product;
import com.eximias.demo.exception.NotFoundException;
import com.eximias.demo.mapper.ProductMapper;
import com.eximias.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Optional<Product> findEntity(int id) {
        return Optional.of(productRepository.findById(id)
                .orElseThrow(NotFoundException::new));
    }

    public List<ProductDTO> findAll() {
        return productMapper.convertToDto(productRepository.findAll());
    }

    public int create(ProductDTO productDto) {
        return productRepository.save(productMapper.convertToEntity(productDto)).getId();
    }

    public void deleteById(int id) {
        Optional<Product> products = productRepository.findById(id);
        if (products.isPresent()) {
            productRepository.deleteById(id);
        }
    }

    public ProductDTO update(int id, ProductDTO productDto) {
        Product updatedProduct = productMapper.convertToEntity(productDto, findEntity(id).get());
        productRepository.save(updatedProduct);
        return productMapper.convertToDto(updatedProduct);
    }

}