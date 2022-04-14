package com.eximias.demo.repository;

import com.eximias.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
