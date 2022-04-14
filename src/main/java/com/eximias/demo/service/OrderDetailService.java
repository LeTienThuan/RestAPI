package com.eximias.demo.service;

import com.eximias.demo.dto.OrderDetailDTO;
import com.eximias.demo.entity.OrderDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailService {

    public OrderDetail convertToEntity(OrderDetailDTO orderDetailDto){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(orderDetailDto.getProduct());
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setTotal(orderDetailDto.getTotal());
        return orderDetail;
    }

    public List<OrderDetail> convertToEntity(List<OrderDetailDTO> orderDetailDto){
        return orderDetailDto
                .stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}
