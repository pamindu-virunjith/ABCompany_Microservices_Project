package com.example.order.common;

import com.example.order.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;

@Getter

public class SuccessOrderResponse implements OrderResponse {
    @JsonUnwrapped // get output without inside another object
    private final OrderDTO order;

    public SuccessOrderResponse(OrderDTO order){
        this.order = order;
    }
}
