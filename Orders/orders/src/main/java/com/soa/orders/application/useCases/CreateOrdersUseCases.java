package com.soa.orders.application.useCases;

import com.soa.orders.application.mapper.IOrderDtoMapper;
import com.soa.orders.application.dtos.request.CreateOrderRequest;
import com.soa.orders.application.dtos.response.BaseResponse;
import com.soa.orders.application.dtos.response.OrderResponse;
import com.soa.orders.domain.models.Order;
import com.soa.orders.domain.port.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateOrdersUseCases {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderDtoMapper orderDtoMapper;

    public BaseResponse excuse(CreateOrderRequest request) {
        Order order = orderDtoMapper.toDomain(request);
        order=orderRepository.save(order);
        OrderResponse orderResponse = orderDtoMapper.toResponse(order);

        return BaseResponse.builder()
                .data(orderResponse)
                .message("order created")
                .success(true)
                .httpStatus(org.springframework.http.HttpStatus.CREATED).build();
    }
}
