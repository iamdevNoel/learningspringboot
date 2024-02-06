package com.iamdevnoel.course.repositories;

import com.iamdevnoel.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
