package com.ti.blog;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ti.blog.entity.User;
import com.ti.blog.entity.Category;
import com.ti.blog.entity.Post;
import com.ti.blog.repository.CategoryRepository;
import com.ti.blog.repository.PostRepository;
import com.ti.blog.repository.UserRepository;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
		System.out.println("Testing the class");
	}

	@Override
	public void run(String... args) throws Exception {

		User[] users = new User[] {
				new User("jose2077", "Jose", "Tabares", "jose@test.com", LocalDate.now(), LocalDate.now()),
				new User("diego_yugi", "Diego", "Arroniz", "diego@test.com", LocalDate.now(), LocalDate.now()),
		};

		Category[] categories = new Category[] {
				new Category("JavaScript", "Blog to talk about JavaScript code", "Open", LocalDate.now(),
						LocalDate.now()),
				new Category("Science Fiction", "Science Fiction Blog", "Open", LocalDate.now(),
						LocalDate.now())
		};

		Post[] posts = new Post[] {
				new Post("How to use React Hooks?", "Lorem ipsum dolor is a ....", LocalDate.now(),
						LocalDate.now(), users[0], categories[0]),
				new Post("Blade runner 2077", "Lorem ipsum dolor is a .....", LocalDate.now(), LocalDate.now(),
						users[1], categories[1])
		};

		for (int i = 0; i < users.length; i++) {
			userRepository.save(users[i]);
			categoryRepository.save(categories[i]);
			postRepository.save(posts[i]);
		}

	}
}
