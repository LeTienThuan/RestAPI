package com.eximias.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private OrderProduct orders;

    private int product;
    private int quantity;
    private double price;
    private double total;

    public OrderDetail() {

    }
}
