package com.example.api_productos.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.api_productos.dto.ProductRequestDTO;
import com.example.api_productos.model.Product;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("Test para ProductRepository")
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private ProductRequestDTO productRequestDTO;
	
	@BeforeEach
	void setup() {
		productRequestDTO = new ProductRequestDTO("Lapicero", "Marca Bic", 5D, 100);
		productRepository.deleteAll();
	}
	
	@DisplayName("Test para guardar producto")
	@Test
	void testSaveProduct() {
		Product saved = productRepository.save(modelMapper.map(productRequestDTO, Product.class));
		assertThat(saved.getId()).isNotNull();
		assertThat(saved.getName()).isEqualTo("Lapicero");
		assertThat(saved.getDescription()).isEqualTo("Marca Bic");
	}
}
