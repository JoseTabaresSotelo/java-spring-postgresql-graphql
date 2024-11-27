package com.ti.blog.service;

import java.util.List;
import com.ti.blog.entity.User;

public interface UserService {
    User getUser(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

    List<User> getUsers();
}