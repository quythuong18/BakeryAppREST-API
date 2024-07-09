package com.quythuong.BakeryManagementSystem.SaleOrder;

import com.quythuong.BakeryManagementSystem.Product.Product;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @SequenceGenerator(
            name = "order_item_sequence",
            sequenceName = "order_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_sequence"
    )
    private Long Id;

    @ManyToOne()
    @JoinColumn(name = "fk_sale_order_id")
    private SaleOrder saleOrder;

    @ManyToOne()
    @JoinColumn(name = "fk_product_id")
    private Product product;

    private Integer amount;

}
