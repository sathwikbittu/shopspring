package com.sathwik.shopspring.services.customer.review;

import com.sathwik.shopspring.dto.OrderedProductsResponseDto;
import com.sathwik.shopspring.dto.ProductDto;
import com.sathwik.shopspring.dto.ReviewDto;
import com.sathwik.shopspring.model.*;
import com.sathwik.shopspring.repository.OrderRepository;
import com.sathwik.shopspring.repository.ProductRepository;
import com.sathwik.shopspring.repository.ReviewRepository;
import com.sathwik.shopspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
        if (optionalOrder.isPresent()) {
            orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());

            List<ProductDto> productDtoList = new ArrayList<>();
            for (CartItems cartItems : optionalOrder.get().getCartItems()) {
                ProductDto productDto = ProductDto.builder()
                        .id(cartItems.getProduct().getId())
                        .name(cartItems.getProduct().getName())
                        .price(cartItems.getPrice())
                        .quantity(cartItems.getQuantity())
                        .byteImg(cartItems.getProduct().getImg())
                        .build();

                productDtoList.add(productDto);
            }

            orderedProductsResponseDto.setProductDtoList(productDtoList);
        }
        log.info("Retrieved ordered products details for order ID: {}", orderId);
        return orderedProductsResponseDto;
    }

    public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());

        if (optionalProduct.isPresent() && optionalUser.isPresent()) {
            Review review = new Review();

            review.setDescription(reviewDto.getDescription());
            review.setRating(reviewDto.getRating());
            review.setUser(optionalUser.get());
            review.setProduct(optionalProduct.get());
            log.info("Review details set for user ID: {} and product ID: {}", reviewDto.getUserId(), reviewDto.getProductId());

            if (reviewDto.getImg() != null) {
                review.setImg(reviewDto.getImg().getBytes());
            }

            return reviewRepository.save(review).getDto();
        }
        log.error("Failed to give review. Product or user not found.");
        return null;
    }
}
