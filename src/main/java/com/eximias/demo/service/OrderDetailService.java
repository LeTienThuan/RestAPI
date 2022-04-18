package com.eximias.demo.service;

import com.eximias.demo.entity.Orders;
import com.eximias.demo.repository.OrderDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public void deleteByOrderId(Orders order) {
        orderDetailRepository.deleteByOrderId(order);
    }
}
