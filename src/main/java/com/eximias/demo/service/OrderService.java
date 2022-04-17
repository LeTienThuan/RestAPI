package com.eximias.demo.service;

import com.eximias.demo.dto.OrderDTO;
import com.eximias.demo.entity.OrderDetail;
import com.eximias.demo.entity.Orders;
import com.eximias.demo.repository.OrderDetailRepository;
import com.eximias.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final OrderDetailService orderDetailService;

    public OrderDTO convertToDto(Orders order){
        OrderDTO orderDto = new OrderDTO();
        orderDto.setId(order.getId());
        orderDto.setCustomer(customerService.convertToDto(order.getCustomer()));
        orderDto.setDeliveryAddress(order.getDeliveryAddress());
        orderDto.setOrderDetail(orderDetailService.convertToDto(order.getOrderDetail()));
        return  orderDto;
    }
    public List<OrderDTO> convertToDto(List<Orders> orders){
        List<OrderDTO> ordersDto = new ArrayList<>();
        for (Orders order : orders) {
            ordersDto.add(convertToDto(order));
        }
        return ordersDto;
    }

    public Orders convertToEntity(OrderDTO orderDto,  Orders order){
        orderDetailService.deleteByOrderId(order);
        order.setCustomer(customerService.convertToEntityBelongToOrder(orderDto.getCustomer()));
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setOrderDetail(orderDetailService.convertToEntity(orderDto.getOrderDetail(), order));
        return order;
    }


    public int create() {
        return orderRepository.save(new Orders()).getId();
   }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public Orders update(int id, OrderDTO orderDto) {
        Optional<Orders> unknownOrder = orderRepository.findById(id);
        if(unknownOrder.isPresent()){
            Orders order = convertToEntity(orderDto, unknownOrder.get());
            orderRepository.save(order);
            return order;
        }else{
            return null;
        }
    }

    public List<OrderDTO> findAll() {
        List<Orders> orders = orderRepository.findAll();
        return convertToDto(orders);
    }
}
