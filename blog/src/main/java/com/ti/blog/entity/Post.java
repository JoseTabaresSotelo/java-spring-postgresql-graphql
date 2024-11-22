package com.ti.blog.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "categoryId")
    private String categoryId;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "commentId")
    private String commentId;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "userId")
    private String userId;

    @FutureOrPresent(message = "The birth date must be in the present")
    @NonNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @FutureOrPresent(message = "The birth date must be in the present")
    @NonNull
    @Column(name = "update_at", nullable = false)
    private LocalDate updatedAt;

}
