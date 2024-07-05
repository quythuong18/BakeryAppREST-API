package com.quythuong.BakeryManagementSystem.Cart;

import com.quythuong.BakeryManagementSystem.Product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    private Cart cart;

    @OneToOne()
    private Product product;

    private int amount;
}
