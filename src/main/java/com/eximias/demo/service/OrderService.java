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
    private final OrderDetailRepository orderDetailRepository;

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


    public int create() {
        return orderRepository.save(new Orders()).getId();
   }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public void update(int id, OrderDTO orderDto) {
        Optional<Orders> order = orderRepository.findById(id);
        if(order.isPresent()){
            Orders realOrder = order.get();
            realOrder.setCustomer(customerService.convertToEntityBelongToOrder(orderDto.getCustomer()));
            realOrder.setDeliveryAddress(orderDto.getDeliveryAddress());
            realOrder.setOrderDetail(orderDetailService.convertToEntity(orderDto.getOrderDetail(), realOrder));
            orderRepository.save(realOrder);
        }

    }

    public List<OrderDTO> findAll() {
        List<Orders> orders = orderRepository.findAll();
        return convertToDto(orders);
    }
}
