package com.andremartins.workshopmongo.config;

import com.andremartins.workshopmongo.domain.Post;
import com.andremartins.workshopmongo.domain.User;
import com.andremartins.workshopmongo.dto.AuthorDto;
import com.andremartins.workshopmongo.repositories.PostRepository;
import com.andremartins.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "BobGrey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, LocalDate.parse("21/06/2018", fmt), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post p2 = new Post(null, LocalDate.parse("23/03/2018", fmt), "Bom dia", "Acordei feliz hoje!",new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(p1, p2));

    }
}