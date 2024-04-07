package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Order;
import com.example.Asm.repository.OrderRepository;
import com.example.Asm.response.OrderResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final OrderRepository repository = new OrderRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<OrderResponse> getAll() {
        List<OrderResponse> responses = new ArrayList<>();
        List<Order> result = repository.getAll();
        for (Order order : result) {
            responses.add(convert.convertOrderToOrderResponse(order));
        }
        return responses;
    }


    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        for (OrderResponse orderResponse : orderService.getAll()) {
            System.out.println(orderResponse);
        }
    }
}
