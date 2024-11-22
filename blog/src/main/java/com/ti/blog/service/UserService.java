package com.ti.blog.service;

import java.util.List;
import java.util.Set;

// import com.ti.blog.entity.Course;
import com.ti.blog.entity.User;

public interface UserService {
    User getUser(Long id);

    User saveUser(User student);

    void deleteUser(Long id);

    List<User> getUsers();

    // Set<Course> getEnrolledCourses(Long id);
}