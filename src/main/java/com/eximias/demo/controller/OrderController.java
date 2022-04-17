package com.eximias.demo.controller;

import com.eximias.demo.dto.OrderDTO;
import com.eximias.demo.entity.Orders;
import com.eximias.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int create() {
        return orderService.create();
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable(name = "id") int id, @RequestBody OrderDTO orderDto) {
        orderService.update(id, orderDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id) {
        orderService.delete(id);
    }
}
