package com.eximias.demo.controller;

import com.eximias.demo.dto.OrderDTO;
import com.eximias.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OrderDTO orderDto){
        orderService.create(orderDto);
    }
}
