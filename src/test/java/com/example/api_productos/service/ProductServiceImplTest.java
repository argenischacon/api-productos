package com.example.api_productos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.api_productos.dto.ProductRequestDTO;
import com.example.api_productos.dto.ProductResponseDTO;
import com.example.api_productos.model.Product;
import com.example.api_productos.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@DisplayName("Tests de Servicios de Producto")
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private ProductServiceImpl productService;
	
	private Product product;
	private ProductRequestDTO productRequestDTO;
	private ProductResponseDTO productResponseDTO;
	
	@BeforeEach
	void setup(){
		product = new Product(1L, "Lapicero", "Marca Bic", 5D, 100);
		productRequestDTO = new ProductRequestDTO("Lapicero", "Marca Bic", 5D, 100);
		productResponseDTO = new ProductResponseDTO(1L, "Lapicero", "Marca Bic", 5D, 100);
	}
	
	@DisplayName("Test para buscar producto por id exitoso")
	@Test
	void testFindProductById_Success() {
		when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		when(modelMapper.map(product, ProductResponseDTO.class)).thenReturn(productResponseDTO);
		
		ProductResponseDTO result = productService.findProductById(1L);
		
		assertEquals(1L, result.getId());
		assertNotNull(result);
		
		verify(productRepository).findById(1L);
		verify(modelMapper).map(product, ProductResponseDTO.class);
	}
	
	@DisplayName("Test para buscar producto por id fallido")
	@Test
	void testFindProductById_NotFound() {
		when(productRepository.findById(1L)).thenThrow(EntityNotFoundException.class);
		
		assertThrows(EntityNotFoundException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				productService.findProductById(1L);
			}
		});
	}
	
	@DisplayName("Test para buscar todos los productos")
	@Test
	void testFindAllProducts() {
		List<Product> products = List.of(product);
		
		when(productRepository.findAll()).thenReturn(products);
		when(modelMapper.map(product, ProductResponseDTO.class))
			.thenReturn(productResponseDTO);
		
		List<ProductResponseDTO> responses = productService.findAllProducts();
		
		assertEquals(1, responses.size());
		assertEquals(1L, responses.get(0).getId());
		
		verify(productRepository).findAll();
		verify(modelMapper).map(product, ProductResponseDTO.class);
	}
	
	@DisplayName("Test para guardar producto")
	@Test
	void testSaveProduct() {
		Product productoMapeado = new Product(null,"Lapicero", "Marca Bic", 5D, 100);
		
		when(modelMapper.map(productRequestDTO, Product.class)).thenReturn(productoMapeado);
		when(productRepository.save(productoMapeado)).thenReturn(product);
		when(modelMapper.map(product, ProductResponseDTO.class)).thenReturn(productResponseDTO);
		
		ProductResponseDTO response = productService.saveProduct(productRequestDTO);
		
		assertNotNull(response);
		assertEquals(1L, response.getId());
		
		verify(modelMapper).map(productRequestDTO, Product.class);
		verify(productRepository).save(productoMapeado);
		verify(modelMapper).map(product, ProductResponseDTO.class);
	}
	
	
}
