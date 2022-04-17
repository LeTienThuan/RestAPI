package com.eximias.demo.repository;

import com.eximias.demo.entity.OrderDetail;
import com.eximias.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Modifying
    @Transactional
    @Query("delete from OrderDetail od where od.orders.id = :#{#order.id}")
    void deleteByOrderId(@Param("order") Orders order);
}
