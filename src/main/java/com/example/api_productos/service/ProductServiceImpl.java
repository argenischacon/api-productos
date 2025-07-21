package com.example.api_productos.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_productos.dto.ProductRequestDTO;
import com.example.api_productos.dto.ProductResponseDTO;
import com.example.api_productos.model.Product;
import com.example.api_productos.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponseDTO findProductById(long id) throws EntityNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(p -> modelMapper.map(p, ProductResponseDTO.class)).toList();
    }

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = productRepository.save(modelMapper.map(productRequestDTO, Product.class));
        return modelMapper.map(newProduct, ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(long id, ProductRequestDTO productRequestDTO) throws EntityNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());

        productRepository.save(product);

        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public void removeProduct(long id) throws EntityNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }

}
