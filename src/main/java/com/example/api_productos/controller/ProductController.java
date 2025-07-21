package com.example.api_productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_productos.dto.ProductRequestDTO;
import com.example.api_productos.dto.ProductResponseDTO;
import com.example.api_productos.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Productos", description = "Endpoints para gestión de productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener un producto por ID",
            description = "Retorna un producto específico según su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto encontrado"),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
            }
    )
    public ResponseEntity<ProductResponseDTO> findByProductById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(productService.findProductById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO newProduct = productService.saveProduct(productRequestDTO);
        return new ResponseEntity<ProductResponseDTO>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,
                                                            @RequestBody ProductRequestDTO productRequestDTO) {
        try {
            ProductResponseDTO updateProduct = productService.updateProduct(id, productRequestDTO);
            return ResponseEntity.ok(updateProduct);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable long id) {
        try {
            productService.removeProduct(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
