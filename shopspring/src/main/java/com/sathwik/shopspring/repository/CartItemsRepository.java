package com.sathwik.shopspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathwik.shopspring.model.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long>{
	
	Optional<CartItems> findByProductIdAndOrderIdAndUserId(Long productId,Long orderId,Long userId);

}
