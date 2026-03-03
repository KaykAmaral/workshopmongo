package com.kaykamaral.workshopmongo.config;

import com.kaykamaral.workshopmongo.domain.User;
import com.kaykamaral.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll(); // Limpa para garantir o teste

        User maria = new User(null, "Kayk", "kayk@gmail.com");
        userRepository.saveAll(Arrays.asList(maria));

        System.out.println(">>> DADO INSERIDO PELO JAVA COM SUCESSO! <<<");
    }
}