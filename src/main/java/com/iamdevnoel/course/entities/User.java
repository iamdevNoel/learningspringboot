package com.iamdevnoel.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // JPA converte esta classe (Orientação a Objeto) em entity (modelo relacional)
@Table(name = "tb_user") // Especifica qual será o nome da classe como tabela SQL
public class User implements Serializable {
    @Id // Explica ao JPA que esse atributo será o ID da tabela SQL
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o JPA autoincrementar a numeração ID
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore // essa annotation evita loopings entre duas classes associadas
    // Neste caso, todo user tem uma order, e toda order tem um user
    // e isso pode gerar um loop ao tentar exibir um user que tem uma order, que tem um user, que tem uma order...
    // recomenda-se que esta annotation fique na classe de relacionamento Um-Para-Muitos
    @OneToMany(mappedBy = "client") // tipo de relacionamento entre objetos (um para muitos)
    // conectado pelo atributo client lá na outra classe
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
