package com.eximias.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetail;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String deliveryAddress;
}
