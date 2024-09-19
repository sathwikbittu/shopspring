package com.sathwik.shopspring.services.admin.adminOrder;

import com.sathwik.shopspring.dto.AnalyticsResponse;
import com.sathwik.shopspring.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {
    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();

    Long getTotalOrdersForMonths(int month, int year);

    Long getTotalEarningsForMonth(int month, int year);
}
