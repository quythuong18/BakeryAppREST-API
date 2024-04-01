package com.example.BakeryManagementSystem.Order;

import com.example.BakeryManagementSystem.Product.Product;
import jakarta.persistence.*;


@Entity
@Table
public class OrderDetails {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product_id")
    private Product product;

    private Integer quantity;

    public OrderDetails(PurchaseOrder purchaseOrder, Product product, Integer quantity) {
        this.purchaseOrder = purchaseOrder;
        this.product = product;
        this.quantity = quantity;
    }
}
