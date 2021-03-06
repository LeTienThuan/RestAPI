package com.eximias.demo.entity;
import com.eximias.demo.entity.Orders;

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
    private Orders orders;

    private int productId;
    private int quantity;
    private double price;
    private double total;

    public OrderDetail() {

    }
}
