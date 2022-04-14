package com.eximias.demo.service;

import com.eximias.demo.dto.OrderDTO;
import com.eximias.demo.entity.Orders;
import com.eximias.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final OrderDetailService orderDetailService;

    public Orders convertToEntity(OrderDTO orderDto){
        Orders order = new Orders();
        order.setCustomer(customerService.convertToEntityBelongToOrder(orderDto.getCustomer()));
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setOrderDetail(orderDetailService.convertToEntity(orderDto.getOrderDetail()));
        return order;
    }

    public void create(OrderDTO orderDto) {
        orderRepository.save(convertToEntity(orderDto));
    }


//    public List<OrderDTO> findAll() {
//        orderRepository.findAll();
//    }
}
