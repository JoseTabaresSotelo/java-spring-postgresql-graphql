package com.ti.blog.service;

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
        System.out.println("======================>" + user);
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

    // @Override
    // public Set<Course> getEnrolledCourses(Long id) {
    // User student = getUser(id);
    // return student.getCourses();
    // }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new UserNotFoundException(id);
    }

}