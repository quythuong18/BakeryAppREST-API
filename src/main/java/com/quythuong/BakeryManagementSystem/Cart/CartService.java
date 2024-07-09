package com.quythuong.BakeryManagementSystem.Cart;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void updateCart(Integer cartId, Cart updatedCart) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalStateException("Cart with id " + cartId + "does not exist"));

        cart.setCartItemList(updatedCart.getCartItemList());

        cartRepository.save(cart);
    }
}
