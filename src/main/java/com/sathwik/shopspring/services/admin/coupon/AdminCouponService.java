package com.sathwik.shopspring.services.admin.coupon;

import java.util.List;

import com.sathwik.shopspring.model.Coupon;

public interface AdminCouponService {
	Coupon createCoupon(Coupon coupon);
	List<Coupon> getAllCoupon();
}
