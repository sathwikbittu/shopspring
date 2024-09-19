package com.sathwik.shopspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathwik.shopspring.model.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
	
	List<Wishlist> findAllByUserId(Long userId);

}
