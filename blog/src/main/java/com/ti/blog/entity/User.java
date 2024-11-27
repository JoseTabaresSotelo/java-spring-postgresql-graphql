package com.ti.blog.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_blog")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @FutureOrPresent(message = "The birth date must be in the present")
    @NonNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @FutureOrPresent(message = "The birth date must be in the present")
    @NonNull
    @Column(name = "update_at", nullable = false)
    private LocalDate updatedAt;

    // @JsonIgnore
    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> Comments;

    // @JsonIgnore
    // @ManyToMany
    // @JoinTable(name = "post_user", joinColumns = @JoinColumn(name = "user_id",
    // referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
    // "post_id", referencedColumnName = "id"))
    // private List<Post> posts;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<Post> posts;

}
