package com.iamdevnoel.course.repositories;

import com.iamdevnoel.course.entities.OrderItem;
import com.iamdevnoel.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
