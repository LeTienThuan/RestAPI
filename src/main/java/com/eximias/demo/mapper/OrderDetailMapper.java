package com.eximias.demo.mapper;

import com.eximias.demo.dto.OrderDetailDTO;
import com.eximias.demo.entity.OrderDetail;
import com.eximias.demo.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    OrderDetailDTO convertToDto(OrderDetail orderDetail);

    List<OrderDetailDTO> convertToDto(List<OrderDetail> orderDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", source = "order")
    OrderDetail convertToEntity(OrderDetailDTO orderDetailDto, Orders order);


    default List<OrderDetail> convertToEntity(List<OrderDetailDTO> orderDetailDto, Orders order, OrderDetailMapper orderDetailMapper) {
        List<OrderDetail> list = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO : orderDetailDto) {
            list.add(orderDetailMapper.convertToEntity(orderDetailDTO, order));
        }
        return list;
    }


}
