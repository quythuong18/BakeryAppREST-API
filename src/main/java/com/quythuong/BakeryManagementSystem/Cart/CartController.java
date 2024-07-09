package com.quythuong.BakeryManagementSystem.Cart;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PatchMapping(path = "{cartId}")
    public void updateCart(@PathVariable("cartId") Integer cartId,
                            @RequestBody Cart updatedCart) {
        cartService.updateCart(cartId, updatedCart);
    }

}
