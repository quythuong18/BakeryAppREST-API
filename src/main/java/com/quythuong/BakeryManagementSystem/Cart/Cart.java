package com.quythuong.BakeryManagementSystem.Cart;

import com.quythuong.BakeryManagementSystem.AppUser.AppUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne()
    private AppUser appUser;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList;
}
