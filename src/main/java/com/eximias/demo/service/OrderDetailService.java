package com.eximias.demo.service;

import com.eximias.demo.dto.OrderDetailDTO;
import com.eximias.demo.entity.OrderDetail;
import com.eximias.demo.entity.Orders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailService {

    public OrderDetail convertToEntity(OrderDetailDTO orderDetailDto, Orders order) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrders(order);
        orderDetail.setProductId(orderDetailDto.getProductId());
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setTotal(orderDetailDto.getTotal());
        System.out.println(orderDetail);
        return orderDetail;
    }

    public List<OrderDetail> convertToEntity(List<OrderDetailDTO> orderDetailDto, Orders order) {
        List<OrderDetail> list = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO : orderDetailDto) {
            list.add(convertToEntity(orderDetailDTO, order));
        }
        return list;
    }

    public OrderDetailDTO convertToDto(OrderDetail orderDetail){
        OrderDetailDTO orderDetailDto = new OrderDetailDTO();
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setProductId(orderDetail.getProductId());
        orderDetailDto.setQuantity(orderDetail.getQuantity());
        orderDetailDto.setPrice(orderDetail.getPrice());
        orderDetailDto.setTotal(orderDetail.getTotal());
        return orderDetailDto;
    }

    public List<OrderDetailDTO> convertToDto(List<OrderDetail> orderDetails){
        List<OrderDetailDTO> orderDetailsDto = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            orderDetailsDto.add(convertToDto(orderDetail));
        }
        return orderDetailsDto;
    }
}
