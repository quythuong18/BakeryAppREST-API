package com.quythuong.BakeryManagementSystem.Cart;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public Cart addCart(Cart cart) {
        cartRepository.save(cart);
        return cart;
    }
}
