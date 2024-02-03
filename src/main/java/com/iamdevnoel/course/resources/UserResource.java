package com.iamdevnoel.course.resources;

import com.iamdevnoel.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Responde requisições http
@RequestMapping(value = "/users") // endereço para acessar este endpoint
public class UserResource {

    @GetMapping // informando o verbo HTTP (GET)
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345678");
        return ResponseEntity.ok().body(user); //
    }

}
