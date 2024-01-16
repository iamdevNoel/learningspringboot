package com.iamdevnoel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iamdevnoel.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
