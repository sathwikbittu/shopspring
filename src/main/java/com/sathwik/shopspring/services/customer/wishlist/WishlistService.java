package com.sathwik.shopspring.services.customer.wishlist;

import java.util.List;

import com.sathwik.shopspring.dto.WishlistDto;

public interface WishlistService {
	WishlistDto addProductToWishlist( WishlistDto wishlistDto);
	
	List<WishlistDto> getWishlistByUserId(Long userId);
}
