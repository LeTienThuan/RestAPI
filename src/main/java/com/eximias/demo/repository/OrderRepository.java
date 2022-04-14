package com.eximias.demo.repository;

import com.eximias.demo.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderProduct, Integer> {
}
