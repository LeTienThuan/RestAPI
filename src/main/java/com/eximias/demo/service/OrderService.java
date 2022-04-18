package com.eximias.demo.service;

import com.eximias.demo.dto.OrderDTO;
import com.eximias.demo.entity.Orders;
import com.eximias.demo.mapper.CustomerMapper;
import com.eximias.demo.mapper.OrderDetailMapper;
import com.eximias.demo.mapper.OrderMapper;
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
    private final CustomerMapper customerMapper;
    private final OrderDetailService orderDetailService;
    private final OrderDetailMapper orderDetailMapper;

    private final OrderMapper orderMapper;

//    public List<OrderDTO> convertToDto(List<Orders> orders) {
//        List<OrderDTO> ordersDto = new ArrayList<>();
//        for (Orders order : orders) {
//            ordersDto.add(orderMapper.convertToDto(order, customerMapper, orderDetailMapper));
//        }
//        return ordersDto;
//    }
    public int create() {
        return orderRepository.save(new Orders()).getId();
    }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public Orders update(int id, OrderDTO orderDto) {
        Optional<Orders> unknownOrder = orderRepository.findById(id);
        if (unknownOrder.isPresent()) {
            orderDetailService.deleteByOrderId(unknownOrder.get());
            Orders order = orderMapper.convertToEntity(orderDto, unknownOrder.get(), customerMapper, orderDetailMapper);
            orderRepository.save(order);
            return order;
        } else {
            return null;
        }
    }

    public List<OrderDTO> findAll() {
        List<Orders> orders = orderRepository.findAll();
        return orderMapper.convertToDto(orders, customerMapper, orderMapper, orderDetailMapper);
    }
}
