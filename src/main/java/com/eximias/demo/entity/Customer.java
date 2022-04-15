package com.eximias.demo.entity;

import lombok.Data;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String address;

    @OneToMany(mappedBy = "")
    List<Orders> ordersList;
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

