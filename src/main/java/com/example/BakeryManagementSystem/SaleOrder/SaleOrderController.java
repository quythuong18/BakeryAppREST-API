package com.example.BakeryManagementSystem.SaleOrder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/orders")
public class SaleOrderController {
    private final SaleOrderService saleOrderService;

    public SaleOrderController(SaleOrderService saleOrderService) {
        this.saleOrderService = saleOrderService;
    }

    @PostMapping
    public ResponseEntity<SaleOrder> addAnOrder(@RequestBody SaleOrder Order) {
        return saleOrderService.addAnOrder(Order);
    }
}
