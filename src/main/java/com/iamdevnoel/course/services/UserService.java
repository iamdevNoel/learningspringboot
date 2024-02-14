package com.iamdevnoel.course.services;

import com.iamdevnoel.course.entities.User;
import com.iamdevnoel.course.repositories.UserRepository;
import com.iamdevnoel.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
    }

    public User insert(User user) {
        return userRepository.save(user);
        //o método save() retorna o tipo de objeto que ele está salvando
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void updateData(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());
    }

    public User update(Long id, User updatedUser) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, updatedUser);
        return userRepository.save(entity);
    }
}
