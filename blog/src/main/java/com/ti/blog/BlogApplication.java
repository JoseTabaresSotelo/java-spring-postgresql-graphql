package com.ti.blog;

import java.security.KeyStore.LoadStoreParameter;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ti.blog.entity.User;
import com.ti.blog.repository.UserRepository;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

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

		for (int i = 0; i < users.length; i++)
			userRepository.save(users[i]);
	}
}
