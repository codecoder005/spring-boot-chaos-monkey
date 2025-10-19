package com.popcorn;

import com.popcorn.entity.UserEntity;
import com.popcorn.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

@SpringBootApplication
public class ChaosEngineeringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaosEngineeringApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            UserEntity john = UserEntity.builder().name("John Doe").email("john.doe@email.com").build();
            userRepository.saveAndFlush(john);
        };
    }

}
