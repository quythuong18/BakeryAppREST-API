package com.quythuong.BakeryManagementSystem.SaleOrder;

import com.quythuong.BakeryManagementSystem.AppUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrder {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "fk_customer_id")
    private AppUser customer;

    @ManyToOne()
    @JoinColumn(name = "fk_employee_id")
    private AppUser employee;

    private String shipAddress;
    private Double total;

    @OneToMany(mappedBy = "saleOrder", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<OrderItem> orderItemList;
}
