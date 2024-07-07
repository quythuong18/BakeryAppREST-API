package com.quythuong.BakeryManagementSystem.Cart;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }
}
