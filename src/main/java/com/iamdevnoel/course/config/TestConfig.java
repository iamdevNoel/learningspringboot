package com.iamdevnoel.course.config;

import com.iamdevnoel.course.entities.Order;
import com.iamdevnoel.course.entities.User;
import com.iamdevnoel.course.repositories.OrderRepository;
import com.iamdevnoel.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration // Explica ao Spring que esta classe é de configuração...
@Profile("test") // ... do perfil "test"
public class TestConfig implements CommandLineRunner {
    // implementa interface para trabalhar com este perfil ao executar o projeto Spring
    @Autowired // Injeção de dependência
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
