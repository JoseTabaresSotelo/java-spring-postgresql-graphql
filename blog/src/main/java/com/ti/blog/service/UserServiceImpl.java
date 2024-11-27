package com.ti.blog.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

// import com.ti.blog.entity.Course;
import com.ti.blog.entity.User;
import com.ti.blog.exception.UserNotFoundException;
import com.ti.blog.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User saveUser(User user) {
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new UserNotFoundException(id);
    }

}