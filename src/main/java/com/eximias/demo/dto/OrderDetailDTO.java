package com.eximias.demo.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private int id;
    private int product;
    private int quantity;
    private double price;
    private double total;
}
