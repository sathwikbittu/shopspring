package com.sathwik.shopspring.services.customer.review;

import java.io.IOException;

import com.sathwik.shopspring.dto.OrderedProductsResponseDto;
import com.sathwik.shopspring.dto.ReviewDto;

public interface ReviewService {
	OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
	
	ReviewDto giveReview(ReviewDto reviewDto) throws IOException ;
}
