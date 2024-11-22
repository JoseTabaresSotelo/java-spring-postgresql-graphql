package com.ti.blog.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column
    private String author;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column
    private String content;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column
    private String status;

    @FutureOrPresent(message = "The birth date must be in the present")
    @NonNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @FutureOrPresent(message = "The birth date must be in the present")
    @NonNull
    @Column(name = "update_at", nullable = false)
    private LocalDate updatedAt;

}
