package com.example.BakeryManagementSystem.SaleOrder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class SaleOrderService {
    private final SaleOrderRepository saleOrderRepository;

    public SaleOrderService(SaleOrderRepository saleOrderRepository) {
        this.saleOrderRepository = saleOrderRepository;
    }

    public ResponseEntity<SaleOrder> addAnOrder(SaleOrder order) {

        for(OrderItem item : order.getOrderItemList()) {
            item.setSaleOrder(order);
        }
        saleOrderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
