package com.quythuong.BakeryManagementSystem.SaleOrder;

import com.quythuong.BakeryManagementSystem.AppUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderDetailsList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "SaleOrder{" +
                "id=" + id +
                ", customer=" + customer +
                ", employee=" + employee +
                ", shipAddress='" + shipAddress + '\'' +
                ", OrderDetailsList=" + orderItemList +
                '}';
    }
}
