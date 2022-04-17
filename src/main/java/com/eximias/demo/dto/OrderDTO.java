package com.eximias.demo.dto;
import com.eximias.demo.dto.CustomerDTO;
import com.eximias.demo.dto.OrderDetailDTO;
import lombok.Data;

import java.util.List;


@Data
public class OrderDTO {
    private int id;
    private CustomerDTO customer;
    private String deliveryAddress;
    private List<OrderDetailDTO> orderDetail;
}
