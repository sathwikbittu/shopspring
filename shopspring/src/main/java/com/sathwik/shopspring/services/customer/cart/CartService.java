package com.sathwik.shopspring.services.customer.cart;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.sathwik.shopspring.dto.AddProductInCartDto;
import com.sathwik.shopspring.dto.OrderDto;
import com.sathwik.shopspring.dto.PlaceOrderDto;

public interface CartService {
	ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

	OrderDto getCartByUserId(Long userId);
	
	OrderDto applyCoupon(Long userId,String code);
	
	OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto placedOrder(PlaceOrderDto placeOrderDto);
	
	List<OrderDto> getMyPlacedOrders(Long userId);
	
	OrderDto searchOrderByTrackingId(UUID trackingId);
}
