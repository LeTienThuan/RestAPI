package com.eximias.demo.entity;

import com.eximias.demo.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Customer customer;
    private String deliveryAddress;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;

    public Order() {

    }
}
