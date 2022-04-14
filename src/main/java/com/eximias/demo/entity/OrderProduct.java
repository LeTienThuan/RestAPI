package com.eximias.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "OrderProduct")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetail;

    private String deliveryAddress;

    public OrderProduct() {

    }
}
