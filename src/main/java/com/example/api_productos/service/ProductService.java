package com.example.api_productos.service;

import java.util.List;

import com.example.api_productos.dto.ProductRequestDTO;
import com.example.api_productos.dto.ProductResponseDTO;

public interface ProductService {
	ProductResponseDTO findProductById(long id);
	List<ProductResponseDTO> findAllProducts();
	ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
	ProductResponseDTO updateProduct(long id, ProductRequestDTO productRequestDTO);
	void removeProduct(long id);
}
