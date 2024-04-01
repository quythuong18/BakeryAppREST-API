package com.example.BakeryManagementSystem.Order;

import com.example.BakeryManagementSystem.AppUser.AppUser;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class PurchaseOrder {
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

    @OneToOne()
    @JoinColumn(name = "fk_customer_id")
    private AppUser customer;

    @OneToOne()
    @JoinColumn(name = "fk_employee_id")
    private AppUser employee;

    private String shipAddress;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<OrderDetails> OrderDetailsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    public AppUser getEmployee() {
        return employee;
    }

    public void setEmployee(AppUser employee) {
        this.employee = employee;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return OrderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        OrderDetailsList = orderDetailsList;
    }
}
