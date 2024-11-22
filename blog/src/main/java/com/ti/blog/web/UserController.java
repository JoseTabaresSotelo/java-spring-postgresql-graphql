package com.ti.blog.web;

import java.util.List;
import java.util.Set;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.blog.entity.User;
import com.ti.blog.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User student) {
        return new ResponseEntity<>(studentService.saveUser(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        studentService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(studentService.getUsers(), HttpStatus.OK);
    }

    // @GetMapping("/{id}/courses")
    // public ResponseEntity<Set<Course>> getEnrolledCourses(@PathVariable Long id)
    // {
    // return new ResponseEntity<>(studentService.getEnrolledCourses(id),
    // HttpStatus.OK);
    // }

}
