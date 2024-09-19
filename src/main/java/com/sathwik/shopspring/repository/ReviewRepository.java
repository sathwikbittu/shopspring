package com.sathwik.shopspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathwik.shopspring.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	List<Review> findAllByProductId(Long productId);

}
