package com.iamdevnoel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iamdevnoel.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
