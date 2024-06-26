package com.soa.orders.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderResponse {
    private String uuid;
    private Long total;
    private String date;
    private String status;
    private List<OrderProductResponse> products;
    private List<InventoryResponse> inventories;
}
