package com.iamdevnoel.course.repositories;

import com.iamdevnoel.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
