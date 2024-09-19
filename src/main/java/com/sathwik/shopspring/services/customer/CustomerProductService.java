package com.sathwik.shopspring.services.customer;

import java.util.List;

import com.sathwik.shopspring.dto.ProductDetailDto;
import com.sathwik.shopspring.dto.ProductDto;

public interface CustomerProductService {
	List<ProductDto> getAllProducts();

	List<ProductDto> getAllProductsByName(String name);
	
	ProductDetailDto getProductDetailById(Long productId);

}
