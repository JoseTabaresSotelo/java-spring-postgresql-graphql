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

    UserRepository studentRepository;

    @Override
    public User getUser(Long id) {
        Optional<User> student = studentRepository.findById(id);
        return unwrapUser(student, id);
    }

    @Override
    public User saveUser(User student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteUser(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) studentRepository.findAll();
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